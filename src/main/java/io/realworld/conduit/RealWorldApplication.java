package io.realworld.conduit;

import com.github.toastshaman.dropwizard.auth.jwt.JwtAuthFilter;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.realworld.conduit.auth.RealWorldAuthenticator;
import io.realworld.conduit.auth.UserPrincipal;
import io.realworld.conduit.core.User;
import io.realworld.conduit.db.UserDAO;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;

public class RealWorldApplication extends Application<RealWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new RealWorldApplication().run(args);
    }

    private final HibernateBundle<RealWorldConfiguration> hibernateBundle =
            new HibernateBundle<RealWorldConfiguration>(User.class) {
                public PooledDataSourceFactory getDataSourceFactory(RealWorldConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<RealWorldConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new MigrationsBundle<RealWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(RealWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    public void run(RealWorldConfiguration configuration, Environment environment) throws Exception {
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
        final byte[] jwtTokenSecret = configuration.getJwtTokenSecret();

        final JwtConsumer consumer = new JwtConsumerBuilder()
                .setAllowedClockSkewInSeconds(30)
                .setRequireExpirationTime()
                .setRequireSubject()
                .setVerificationKey(new HmacKey(jwtTokenSecret))
                .setRelaxVerificationKeyValidation()
                .build();

        environment.jersey().register(new AuthDynamicFeature(
                new JwtAuthFilter.Builder<UserPrincipal>()
                    .setJwtConsumer(consumer)
                    .setRealm("realm")
                    .setPrefix("Token")
                    .setAuthenticator(new RealWorldAuthenticator())
                    .buildAuthFilter()));
    }
}
