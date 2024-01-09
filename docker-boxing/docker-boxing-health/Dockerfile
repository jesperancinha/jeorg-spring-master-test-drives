FROM azul/zulu-openjdk:21.0.1-jre-headless

RUN apt update -y

RUN apt install curl -y

COPY target/docker-boxing-health.jar ~/
