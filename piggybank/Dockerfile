FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/piggybank-0.0.1-SNAPSHOT.jar piggybank-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "piggybank-0.0.1-SNAPSHOT.jar"]