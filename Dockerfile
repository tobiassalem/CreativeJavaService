# Build with Maven
FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY tasklist-service.yml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Run with Java
FROM openjdk:8
# Alt. run with Google distroless. NB! Not suitable for this specific microservice (it won't have any tasks to list).
# Ref. https://github.com/GoogleContainerTools/distroless
# FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/tasklist-service-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/tasklist-service-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY --from=build /usr/src/app/tasklist-service.yml /usr/app/tasklist-service.yml
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/tasklist-service-1.0-SNAPSHOT-jar-with-dependencies.jar", "server", "/usr/app/tasklist-service.yml"]