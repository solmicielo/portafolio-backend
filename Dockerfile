FROM openjdk:17-jdk-slim-buster

MAINTAINER solcarretero

COPY target/portafolio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]








