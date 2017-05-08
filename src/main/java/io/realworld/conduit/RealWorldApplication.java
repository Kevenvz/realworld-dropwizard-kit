package io.realworld.conduit;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.realworld.conduit.core.User;
import io.realworld.conduit.db.UserDAO;

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

    public void run(RealWorldConfiguration configuration, Environment environment) {
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
    }
}
