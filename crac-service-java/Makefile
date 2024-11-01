include ../Makefile.mk

SETUP := export SDKMAN_DIR="$(HOME)/.sdkman"; \
         	[[ -s "$(HOME)/.sdkman/bin/sdkman-init.sh" ]]; \
			source "$(HOME)/.sdkman/bin/sdkman-init.sh" ;\
			sdk use java 21.0.4.crac-zulu

first-install:
	$(SETUP); \
	sdk install java 21.0.4.crac-zulu
jdk-setup:
	$(SETUP); \
	sudo chown root:root $(JAVA_HOME)/lib/criu ; \
	sudo chmod u+s $(JAVA_HOME)/lib/criu
b: build-maven
build-maven:
	$(SETUP); \
  	mvn clean install
start-service: cleanup
	$(SETUP); \
	java -jar target/crac-service-java.jar
start-service-crac: cleanup
	$(SETUP); \
	java -version; \
	java -XX:CRaCCheckpointTo=./tmp_checkpoint -cp target/crac-service-java.jar org.jesperancinha.cracservice.CracServiceApplication
start-siege:
	siege -c 1 -r 100000 -b http://localhost:8080
create-checkpoint:
	$(SETUP); \
	jcmd target/crac-service-java.jar JDK.checkpoint
start-checkpoint:
	$(SETUP); \
	java -XX:CRaCRestoreFrom=./tmp_checkpoint -jar target/crac-service-java.jar
cleanup:
	if [ -d tmp_checkpoint ]; then rm -rf tmp_checkpoint; fi;
docker-build-start:
	docker-compose up --build
docker-start:
	docker-compose up -d
docker-start-service:
	docker-compose exec crac_service java -jar /opt/app/crac-service-java.jar
docker-start-service-crac:
	docker-compose exec crac_service java -XX:CRaCCheckpointTo=./tmp_checkpoint -jar /opt/app/crac-service-java.jar
docker-checkpoint-service-crac:
	docker-compose exec crac_service jcmd /opt/app/crac-service-java.jar JDK.checkpoint
docker-resume-service-crac:
	docker-compose exec crac_service java -XX:CRaCRestoreFrom=./tmp_checkpoint