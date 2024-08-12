# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from your Maven target directory to the container
COPY target/reservation-service-1.0.0.jar /app/reservation-service.jar

# Make port 8082 available to the world outside this container
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/reservation-service.jar"]
