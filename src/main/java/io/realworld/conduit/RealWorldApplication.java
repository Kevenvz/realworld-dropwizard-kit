package io.realworld.conduit;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;

public class RealWorldApplication extends Application<RealWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new RealWorldApplication().run(args);
    }

    /*private final HibernateBundle<RealWorldConfiguration> hibernateBundle =
            new HibernateBundle<RealWorldConfiguration>() {
                public PooledDataSourceFactory getDataSourceFactory(RealWorldConfiguration realWorldConfiguration) {
                    return null;
                }
            };*/

    public void run(RealWorldConfiguration realWorldConfiguration, Environment environment) {

    }
}
