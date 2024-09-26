# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Copy the JAR file from the host to the container
COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar myapp.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "/myapp.jar"]
