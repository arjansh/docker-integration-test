# docker-integration-test

[![Build Status: Linux](https://travis-ci.org/arjansh/docker-integration-test.svg?branch=master)](https://travis-ci.org/arjansh/docker-integration-test)

Showcase for running integration tests through Maven on a Tomcat Docker container.

To be able to run the project you need to have the following installed:

 * Java 8
 * Maven 3
 * Docker
 
Furthermore, depending on your setup the following environment variables may have to be set:

 * DOCKER_HOST - contains the URL of the Docker Daemon, e.g. http://localhost:2375 or tcp://192.168.99.1000:2376.
 * DOCKER_CERT_PATH - contains the path to the SSL certificate when SSL is used for communicating with the Docker daemon, e.g. ~/.docker/ or C:\Users\\[username]\\.docker\machine\certs.
 
Now you can run the project using

```
mvn clean verify
```

By default it starts tomcat on port 8080, you can override this using the dockerTomcatPort maven property if you want to run it on another port, e.g. `mvn clean verify -PdockerTomcatPort=8081`.
