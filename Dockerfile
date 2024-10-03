FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pet-consumer.jar
ENTRYPOINT ["java", "-jar", "/pet-consumer.jar"]

