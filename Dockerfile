FROM openjdk:8-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pet-consumer.jar
ENTRYPOINT ["java", "-jar", "/pet-counser.jar"]
