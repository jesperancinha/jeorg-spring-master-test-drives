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
copy-jre-to-local:
	if [ -d current-jdk/current ]; then rm -rf current-jdk/current; fi; \
	mkdir -p current-jdk/current;
	cp -r $(JAVA_HOME)/ current-jdk/;
jlink-jre:
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
build-jlink-docker-image: jlink-jre
	docker build -t the-validation-company:latest .
build-current-jdk-docker-image: copy-jre-to-local
	cp build/libs/the-validation-company-simple-cds.jar current-jdk
	docker build -t the-validation-company-current-jdk:latest current-jdk/.
	current-jdk/current/bin/java \
		-Dspring.context.exit=onRefresh \
		-jar build/libs/the-validation-company-simple-cds.jar
build-traditional-jre-docker-image:
	cp build/libs/the-validation-company-simple-cds.jar traditional-jre
	docker build -t the-validation-company-traditional-jre:latest traditional-jre/.
build-jlink-example-images: build-jlink-docker-image build-current-jdk-docker-image build-traditional-jre-docker-image
run-link-docker-image:
	docker run --rm the-validation-company:latest
	docker images --filter "reference=the-validation-company"
run-current-jdk-docker-image:
	docker run --rm the-validation-company-current-jdk:latest
	docker images --filter "reference=the-validation-company-current-jdk"
run-traditional-jre-docker-image:
	docker run --rm the-validation-company-current-jdk:latest
	docker images --filter "reference=the-validation-company-traditional-jre"
show-jlink-images:
	docker images --filter "reference=the-validation-company*"

jlink-feature-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods:../print-module/build/libs --add-modules java.base,java.desktop,java.management,java.logging,java.instrument,jesperancinha.module \
          --output the-validation-company-jre; \
    du -sh the-validation-company-jre; \
    the-validation-company-jre/bin/java \
		-jar app.jar
build-aux: clean
	export JAVA_HOME=./the-validation-company-jre; \
	gradle build --stacktrace;
compile-with-external:
	kotlinc -d app.jar \
		   -classpath ../print-module/build/libs/print-module.jar:../print-module/build/libs/kotlin-stdlib-2.1.0.jar \
		   src/main/kotlin/org/jesperancinha/smtd/SimpleCdsApplication.kt
run-with-external:
	java -classpath app.jar:../print-module/build/libs/kotlin-stdlib-2.1.0.jar \
		 org.jesperancinha.smtd.SimpleCdsApplication
run-with-custom-jre-external:
	the-validation-company-jre/bin/java -classpath app.jar:../print-module/build/libs/kotlin-stdlib-2.1.0.jar \
		 org.jesperancinha.smtd.SimpleCdsApplication

jlink-feature-runnable-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods:../runnable-module/build/libs --add-modules java.base,java.desktop,java.management,java.logging,java.instrument,runnable.module \
          --output the-validation-company-jre \
          --launcher runnable=runnable.module/org.jesperancinha.smtd.Runnable; \
    du -sh the-validation-company-jre; \

jlink-small-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods \
          --add-modules java.base \
          --no-header-files \
          --strip-debug \
          --compress=2 \
          --output the-validation-company-jre; \
    du -sh the-validation-company-jre; \
    the-validation-company-jre/bin/java \
		-jar build/libs/the-validation-company-simple-cds.jar