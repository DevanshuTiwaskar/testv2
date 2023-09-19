FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/piggybank-0.0.1-SNAPSHOT.jar /app/piggybank.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "piggybank.jar"]