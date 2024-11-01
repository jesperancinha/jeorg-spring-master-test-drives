include ../Makefile.mk

SETUP := export SDKMAN_DIR="$(HOME)/.sdkman"; \
         	[[ -s "$(HOME)/.sdkman/bin/sdkman-init.sh" ]]; \
			source "$(HOME)/.sdkman/bin/sdkman-init.sh" ;\
			sdk use java 21.0.4.crac-zulu

jdk-setup:
	$(SETUP); \
	sudo chown root:root $(JAVA_HOME)/lib/criu ; \
	sudo chmod u+s $(JAVA_HOME)/lib/criu
build-maven:
	mvn clean install
start-crac-classes:
	java -XX:CRaCCheckpointTo=./tmp_checkpoint -cp target/crac-runner-java.jar org.jesperancinha.smtd.CracRunner
restore-crac-classes:
	java -XX:CRaCRestoreFrom=./tmp_checkpoint -cp target/crac-runner-java.jar org.jesperancinha.smtd.CracRunner

# We need to start the application with the class path of the jar
start-crac:
	java -XX:CRaCCheckpointTo=./tmp_checkpoint -jar target/crac-runner-java.jar
restore-crac:
	java -XX:CRaCRestoreFrom=./tmp_checkpoint -jar target/crac-runner-java.jar
