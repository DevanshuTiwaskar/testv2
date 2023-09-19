FROM openjdk:8-jdk-alpine
#WORKDIR /app
COPY piggybank.jar piggybank.jar
EXPOSE 8080
 CMD ["java","-jar","/piggybank.jar"]
#ENTRYPOINT ["java", "-jar", "piggybank-0.0.1-SNAPSHOT.jar"]
ENV JAVA_OPTS=""