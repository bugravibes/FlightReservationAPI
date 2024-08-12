FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/reservation-search-1.0.0.jar /app/reservation-search.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "reservation-search.jar"]
