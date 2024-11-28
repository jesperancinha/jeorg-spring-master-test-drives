include Makefile.mk

MODULE_LOCATIONS := the-validation-company \
					repeated-dislikes

b: build
build: build-gradle build-maven
build-maven:
	java -version
	mvn clean install -DskipTests
	mvn test
build-gradle:
	gradle wrapper; \
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
upgrade-gradle: upgrade-system upgrade-sdk-man upgrade
upgrade-system:
	sudo apt upgrade
	sudo apt update
upgrade-sdk-man:
	export SDKMAN_DIR="$(HOME)/.sdkman"; \
	[[ -s "$(HOME)/.sdkman/bin/sdkman-init.sh" ]]; \
	source "$(HOME)/.sdkman/bin/sdkman-init.sh"; \
	sdk update; \
	gradleOnlineVersion=$(shell curl -s https://services.gradle.org/versions/current | jq .version | xargs -I {} echo {}); \
	if [[ -z "$$gradleOnlineVersion" ]]; then \
		sdk install gradle $(GRADLE_VERSION); \
		sdk use gradle $(GRADLE_VERSION); \
	else \
		sdk install gradle $$gradleOnlineVersion; \
		sdk use gradle $$gradleOnlineVersion; \
		export GRADLE_VERSION=$$gradleOnlineVersion; \
	fi;
upgrade:
	@for location in $(MODULE_LOCATIONS); do \
  		export CURRENT=$(shell pwd); \
  		echo "Upgrading $$location..."; \
		cd $$location; \
		gradle wrapper --gradle-version $(GRADLE_VERSION); \
		cd $$CURRENT; \
	done
local-pipeline: local no-test b
rewrite:
	mvn rewrite:run
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash -s -- $(PARAMS)
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-gradle-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/gradleUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-gradle-update
update-repo-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/update-all-repo-prs.sh | bash
accept-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/acceptPR.sh | bash

