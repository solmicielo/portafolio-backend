FROM amazoncorretto:17-alpine-jdk

MAINTAINER SolCarretero

COPY target/portafolio-0.0.1-SNAPSHOT  sol-portafolio.jar

ENTRYPOINT ["java","-jar","/sol-portafolio.jar"]
