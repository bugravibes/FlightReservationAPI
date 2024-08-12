# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/ticketing-service-1.0.0.jar /app/ticketing-service.jar

# Make port 8080 available to the world outside this container
EXPOSE 8083

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/ticketing-service.jar"]
