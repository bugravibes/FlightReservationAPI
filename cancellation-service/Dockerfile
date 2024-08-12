FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/cancellation-service-1.0.0.jar /app/cancellation-service.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "cancellation-service.jar"]
