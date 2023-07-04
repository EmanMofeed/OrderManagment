# This Dockerfile sets up a container with Java 17 and runs a Java application

# Use a base image with Java 17
FROM openjdk:17

# Expose port 8081 for the application
EXPOSE 8081

# Copy the JAR file to the container
COPY target/demo-1.0-SNAPSHOT.jar /app/demo-1.0-SNAPSHOT.jar

# Set the working directory to /app
WORKDIR /app

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "demo-1.0-SNAPSHOT.jar"]