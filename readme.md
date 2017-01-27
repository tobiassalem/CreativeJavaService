##CreativeJavaService

A simple proof of concept example Java microservice.
The service lists process tasks on the system in question and is built using Dropwizard and Maven build manager.
The service assumes it is run on a system where the "ps -e" terminal command is valid. Concretely Linux/Unix and Windows 10 works fine.

###Building
Install Maven if not already present on your system
Build it with mvn install.

###Running
* You can run it with java -jar target/tasklist-service-1.0-SNAPSHOT.jar server tasklist-service.yml.
* You check the service output on http://localhost:8080/task-list

###References
* Dropwizard @See http://www.dropwizard.io/1.0.5/docs/
* Java Microservices @See http://www.javaworld.com/article/2683277/architecture-scalability/what-microservices-architecture-really-means.html
* Maven @See https://maven.apache.org/