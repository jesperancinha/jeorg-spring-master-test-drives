SHELL := /bin/bash

b: build
build: build-gradle build-maven
build-maven:
	java -version
	mvn clean install -DskipTests
	mvn test
build-gradle:
	cd the-validation-company; \
	./gradlew build; \
	gradle test
test:
	mvn test
local:
	mkdir -p bin
no-test:
	mvn clean install -DskipTests
docker-delete:
	docker ps -a --format '{{.ID}}' | xargs -I {}  docker stop {}
	docker ps -a --format '{{.ID}}' | xargs -I {}  docker rm {}
prune-all: docker-delete
	docker network prune
	docker system prune --all
	docker builder prune
	docker system prune --all --volumes
run-jar-health:
	java -jar docker-boxing/docker-boxing-health/target/docker-boxing-health.jar
run-jar-port:
	java -jar docker-boxing/docker-boxing-port/target/docker-boxing-port.jar
resolve:
	mvn dependency:resolve
