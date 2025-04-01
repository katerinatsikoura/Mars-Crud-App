# use an official OpenJDK runtime as a base image
FROM openjdk:21-jdk-slim

# set a working directory in the container
WORKDIR /app

# copy the built JAR  into the containers
COPY target/mars-crud-app-*.jar app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
