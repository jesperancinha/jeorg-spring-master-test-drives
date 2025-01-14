include ../Makefile.mk

b: wrapper clean build
wrapper:
	cd ..; \
  	gradle wrapper;
clean:
	if [ -d build ]; then rm -r build; fi;
	if [ -f application.jsa ]; then rm application.jsa; fi;
	if [ -f classlist.txt ]; then rm classlist.txt; fi;
build: clean
	gradle build;
run:
	java -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -Xlog:startuptime \
		 -jar build/libs/the-validation-company-simple-cds.jar --keep
verify-cds:
	find ~/.sdkman/ -name "classes.jsa"

# CDS
cds-extract:
	java -Djarmode=tools \
		  -jar build/libs/the-validation-company-simple-cds.jar extract
cds-class-list:
	java -Xshare:off \
		 -XX:DumpLoadedClassList=classlist.txt \
		 -cp build/libs/the-validation-company-simple-cds.jar \
		 org.jesperancinha.smtd.Main
cds-archive:
	java -Xshare:dump \
         -XX:SharedClassListFile=classlist.txt \
         -XX:SharedArchiveFile=application.jsa \
         -cp build/libs/the-validation-company-simple-cds.jar
cds-launch:
	java -Xshare:on \
		 -Xlog:startuptime \
         -XX:SharedArchiveFile=application.jsa \
         -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -jar build/libs/the-validation-company-simple-cds.jar --keep
cds-launch-logs:
	java -Xshare:on \
         -XX:SharedArchiveFile=application.jsa \
         -Xlog:cds \
         -jar build/libs/the-validation-company-simple-cds.jar
# Verify CDS
cds-verify-class-loading:
	jcmd build/libs/the-validation-company-simple-cds.jar VM.classloader_stats
cds-verify-cds-logs:
	java -Xlog:cds -jar build/libs/the-validation-company-simple-cds.jar
cds-verify-class-loaders:
	jcmd build/libs/the-validation-company-simple-cds.jar VM.classloaders
cds-verify-native-memory:
	jcmd build/libs/the-validation-company-simple-cds.jar VM.native_memory summary
cds-verify-issued-commands:
	jcmd build/libs/the-validation-company-simple-cds.jar VM.command_line
cds-verify-system-properties:
	jcmd build/libs/the-validation-company-simple-cds.jar VM.system_properties
cds-verify-all: cds-verify-class-loading cds-launch-logs cds-verify-class-loaders cds-verify-native-memory cds-verify-issued-commands cds-verify-system-properties

# JLINK experiments
cds-jlink-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods \
          --add-modules java.base \
          --output the-validation-company-jre; \
    du -sh the-validation-company-jre; \
    the-validation-company-jre/bin/java \
		-jar build/libs/the-validation-company-simple-cds.jar
docker-delete:
	docker ps -a --format '{{.ID}}' --filter "name=the-validation-company*" | xargs -I {}  docker stop {}
	docker ps -a --format '{{.ID}}' --filter "name=the-validation-company*" | xargs -I {}  docker rm {}
	docker images -a --format '{{.ID}}' --filter "reference=the-validation-company*" | xargs -I {} docker rmi {}
build-jlink-docker-image: cds-jlink-jre
	docker build -t the-validation-company:latest .
build-traditional-docker-image:
	cp build/libs/the-validation-company-simple-cds.jar traditional
	docker build -t the-validation-company-traditional:latest traditional/.
build-jlink-example-images: build-jlink-docker-image build-traditional-docker-image
run-link-docker-image:
	docker run --rm the-validation-company:latest
	docker images --filter "reference=the-validation-company"
run-traditional-docker-image:
	docker run --rm the-validation-company-traditional:latest
	docker images --filter "reference=the-validation-company-traditional"
show-jlink-images:
	docker images --filter "reference=the-validation-company*"

cds-jlink-feature-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods:../print-module/build/libs --add-modules java.base,java.desktop,java.management,java.logging,java.instrument,jesperancinha.module \
          --output the-validation-company-jre; \
    du -sh the-validation-company-jre; \
    the-validation-company-jre/bin/java \
		-jar build/libs/the-validation-company-simple-cds.jar
build-aux: clean
	export JAVA_HOME=./the-validation-company-jre; \
	gradle build --stacktrace ;