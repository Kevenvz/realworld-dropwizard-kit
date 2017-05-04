package io.realworld.conduit;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RealWorldApplication extends Application<RealWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new RealWorldApplication().run(args);
    }

    public void run(RealWorldConfiguration realWorldConfiguration, Environment environment) {

    }
}
