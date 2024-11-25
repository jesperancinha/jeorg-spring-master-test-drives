include ../Makefile.mk

b: wrapper clean build
wrapper:
	cd ..; \
  	gradle wrapper;
clean:
	if [ -d build ]; then rm -r build; fi;
build: clean
	./gradlew build;
run:
	./gradlew bootRun;

#Spring CDS ---

cds-extract:
	java -Djarmode=tools -jar build/libs/the-validation-company.jar extract
cds-archive:
	java -XX:ArchiveClassesAtExit=./application.jsa -Dspring.context.exit=onRefresh -jar the-validation-company/the-validation-company.jar
cds-launch:
	java -XX:SharedArchiveFile=application.jsa -jar the-validation-company/the-validation-company.jar
cds-launch-logs:
	java -XX:ArchiveClassesAtExit=application.jsa -Xlog:cds=debug:file=the-validation-company/cds.log -Dspring.context.exit=onRefresh -jar the-validation-company/the-validation-company.jar
cds-launch-logs-detail:
	java -XX:SharedArchiveFile=application.jsa -Xlog:class+load=info:file=the-validation-company/class-load.log -Xlog:class+path=debug:file=the-validation-company/class-path.log -jar the-validation-company/the-validation-company.jar
