# docker-integration-test

[![Build Status: Linux](https://travis-ci.org/arjansh/docker-integration-test.svg?branch=master)](https://travis-ci.org/arjansh/docker-integration-test)

Showcase for running integration tests through Maven on a Tomcat Docker container.

To be able to run the project you need to have the following installed:

 * Java 8
 * Maven 3
 * Docker
 
Furthermore the following environment variables have to be set:

 * DOCKER_HOST_NAME - contains the host name of your Docker Daemon, e.g. localhost or 192.168.99.100.
 * DOCKER_HOST - contains the URL of the Docker Daemon, e.g. http://localhost:2375 or tcp://192.168.99.1000:2376.
 * DOCKER_CERT_PATH - contains the path to the SSL certificate when SSL is used for communicating with the Docker daemon, e.g. ~/.docker/ or C:\Users\\[username]\\.docker\machine\certs.
 
The DOCKER_HOST_NAME have to be set in all use cases. DOCKER_HOST and DOCKER_CERT_PATH may not be necessary depending on your setup.

Now you can run the project using

```
mvn clean verify
```
