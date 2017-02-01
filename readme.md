##CreativeJavaService

A very simple proof of concept Java microservice. The ambition is to use Best Practices like Clean Code and Design Patterns wherever possible. 
The service simply lists process tasks on the system in question. It is built using Dropwizard and Maven build manager.
The service assumes it is run on a system where the "ps -e" terminal command is valid. Concretely Linux/Unix and Windows 10 works fine.

There are of course many Java frameworks for developing ops-friendly, RESTful web services. 
I here selected Dropwizard for it's elegance and simplicity.

###Building
* Install Maven if not already present on your system (if you have an IDE like IntelliJ you're all set).
* Build it with mvn install (if you have IntelliJ, simply run lifecycle goal "install" in the Maven Projects tool window).

###Running
* You run it with java -jar target/tasklist-service-1.0-SNAPSHOT.jar server tasklist-service.yml.
* You check the service output on http://localhost:8080/task-list
* If you want to filter the process task list you add the query parameter "contains". For example:
    * http://localhost:8080/task-list?contains=bin  to only get tasks in the /bin folder.
    * http://localhost:8080/task-list?contains=frodo to only get tasks with frodo in the content (probably an empty list).

###Possible improvements
The possible improvements to the application are of course many. The most relevant can easily be the following.

* Implement unit tests. [done]
* Implement support for more platforms and commands. [nice to have]
        
###References
* Dropwizard - @See http://www.dropwizard.io/
* Maven build manager - @See https://maven.apache.org/
* Java Microservices - @See http://www.javaworld.com/article/2683277/architecture-scalability/what-microservices-architecture-really-means.html
* Clean Code by Robert C. Martin - @See https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882