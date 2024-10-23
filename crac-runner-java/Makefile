build-maven:
	mvn clean install
start-crac:
	java -XX:CRaCCheckpointTo=./tmp_checkpoint -jar target/crac-runner-java.jar
restore-crac:
	java -XX:CRaCRestoreFrom=./tmp_checkpoint -jar target/crac-runner-java.jar
start-crac-classes:
	java -XX:CRaCCheckpointTo=./tmp_checkpoint -cp target/crac-runner-java.jar org.jesperancinha.smtd.CracRunner
restore-crac-classes:
	java -XX:CRaCRestoreFrom=./tmp_checkpoint -cp target/crac-runner-java.jar org.jesperancinha.smtd.CracRunner