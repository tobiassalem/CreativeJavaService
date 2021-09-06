## CreativeJavaService

A very simple proof of concept Java microservice. The ambition is to use Best Practices like Clean Code and Design Patterns wherever possible. 
The service simply lists process tasks on the system in question. It is built using Dropwizard and Maven build manager.
The service assumes it is run on a system where the "ps -e" terminal command is valid. Concretely Linux/Unix and Windows 10 works fine.

There are of course many Java frameworks for developing ops-friendly, RESTful web services. 
I here selected Dropwizard for its elegance and simplicity (a good alternative is Spring Boot).

### Requirements
Any system with Java 8+ and Maven 3 installed.
* Java can be found at https://www.java.com/
* Maven can be found at https://maven.apache.org/

Alternatively, any system with Docker installed.
* Docker can be found at https://www.docker.com/ with docs at https://docs.docker.com/
* NB! The output will be more interesting running on a proper system, since a docker container has very few processes.

### Building
* Open a terminal and go to the project folder (with the Maven `pom.xml`).
* Build with `mvn install`.
* With an IDE like IntelliJ: simply run lifecycle goal "install" in the Maven Projects tool window.
* With Docker: `docker build -t creative-java-service .`

### Running
* Open a terminal and go to the project folder.
* You run it with `java -jar target/tasklist-service-1.0-SNAPSHOT-jar-with-dependencies.jar server tasklist-service.yml`
* With Docker: `docker run --rm -dp 8080:8080 -t creative-java-service:latest`
* You check the service output on http://localhost:8080/task-list
* To filter the process task list you add the query parameter `contains`. For example:
    * http://localhost:8080/task-list?contains=bin to only get tasks in the /bin folder.
    * http://localhost:8080/task-list?contains=java to only get java in tasks.
    * http://localhost:8080/task-list?contains=frodo to only get tasks with frodo in the content (probably an empty list).

### Possible improvements
The possible improvements to the application are of course many. The most relevant can easily be the following.

* Implement unit tests. [done]
* Implement Dockerfile. [done]  
* Implement support for more platforms and commands. [nice to have]
        
### References
* Dropwizard - @See http://www.dropwizard.io/
* Maven build manager - @See https://maven.apache.org/
* Java Microservices - @See http://www.javaworld.com/article/2683277/architecture-scalability/what-microservices-architecture-really-means.html
* Clean Code by Robert C. Martin - @See https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882