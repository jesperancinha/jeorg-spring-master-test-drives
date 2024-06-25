FROM eclipse-temurin:21-alpine

RUN apt update -y

RUN apt install curl -y

COPY target/docker-boxing-port.jar ~/

EXPOSE 8080