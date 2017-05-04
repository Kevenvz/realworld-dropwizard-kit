# ![RealWorld Example App](logo.png)

> ### Dropwizard codebase containing real world examples (CRUD, auth, advanced patterns, etc) that adheres to the [RealWorld](https://github.com/gothinkster/realworld-example-apps) spec and API.


### [Demo]()&nbsp;&nbsp;&nbsp;&nbsp;[RealWorld](https://github.com/gothinkster/realworld)


This codebase was created to demonstrate a fully fledged fullstack application built with Dropwizard including CRUD operations, authentication, routing, pagination, and more.

We've gone to great lengths to adhere to the Dropwizard community styleguides & best practices.

For more information on how to this works with other frontends/backends, head over to the [RealWorld](https://github.com/gothinkster/realworld) repo.


# How it works

This is using [Dropwizard](http://www.dropwizard.io/) to create a backend.

# Getting started

You need to install the [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and [Maven](https://maven.apache.org/) to build the project.

Once you have installed the JDK and Maven run the following command to build the project: `mvn package`

When the build is successful you'll see a `target` directory appear and then you can continue to run the project using the following command `java -jar target/io.realworld.conduit-1.0-SNAPSHOT.jar server`
