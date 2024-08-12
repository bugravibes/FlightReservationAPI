# Use a Maven image to build the project
FROM maven:3.8.5-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and install dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/auth-service-1.0-SNAPSHOT.jar /app/auth-service.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]
