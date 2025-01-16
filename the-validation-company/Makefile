include ../Makefile.mk

b: wrapper clean build
wrapper:
	cd ..; \
  	gradle wrapper;
clean:
	if [ -d build ]; then rm -r build; fi;
	if [ -d the-validation-company ]; then rm -r the-validation-company; fi;
	if [ -f application.jsa ]; then rm application.jsa; fi;
	if [ -f classlist.txt ]; then rm classlist.txt; fi;
build: clean
	gradle build;
run-gradle:
	gradle bootRun;
run:
	java -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -Xlog:startuptime \
		 -jar build/libs/the-validation-company.jar
run-unpacked:
	java -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -Xlog:startuptime \
		 -jar the-validation-company/the-validation-company.jar

# Spring CDS ---
cds-extract:
	java -Djarmode=tools \
		-jar build/libs/the-validation-company.jar extract
cds-archive:
	java -XX:ArchiveClassesAtExit=./application.jsa \
		-Dspring.context.exit=onRefresh \
		-Dspring.aot.enabled=false \
		-jar the-validation-company/the-validation-company.jar
cds-archive-aot:
	java -XX:ArchiveClassesAtExit=./application.jsa \
		-Dspring.context.exit=onRefresh \
		-Dspring.aot.enabled=true \
		-jar the-validation-company/the-validation-company.jar
cds-launch:
	java -XX:SharedArchiveFile=application.jsa \
		-XX:+UnlockDiagnosticVMOptions \
      	-XX:NativeMemoryTracking=summary \
		-jar the-validation-company/the-validation-company.jar
cds-launch-aot:
	java -XX:SharedArchiveFile=application.jsa \
		-XX:+UnlockDiagnosticVMOptions \
		-XX:NativeMemoryTracking=summary \
      	-Dspring.aot.enabled=true \
		-jar the-validation-company/the-validation-company.jar
cds-launch-logs:
	java -XX:ArchiveClassesAtExit=application.jsa \
		-Xlog:cds=debug:file=the-validation-company/cds.log -Dspring.context.exit=onRefresh -jar the-validation-company/the-validation-company.jar
cds-launch-logs-detail:
	java -XX:SharedArchiveFile=application.jsa \
		-Xlog:class+load=info:file=the-validation-company/class-load.log \
		-Xlog:class+path=debug:file=the-validation-company/class-path.log \
		-jar the-validation-company/the-validation-company.jar

# Spring CDS --- The old way
# This command will hang in a Spring application
cds-old-class-list:
	java -Xlog:class+load -jar build/libs/the-validation-company.jar > classlist.txt
# This would create the jsa file - it doesn't work in spring applications
# Use cds-archive to create the Java Shared Archive file instead
cds-old-archive:
	java -Xshare:dump \
         -XX:SharedClassListFile=classlist.txt \
         -XX:SharedArchiveFile=application.jsa \
         -cp build/libs/the-validation-company.jar
cds-old-launch:
	java -Xshare:on \
         -XX:SharedArchiveFile=application.jsa \
         -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -jar the-validation-company/the-validation-company.jar
cds-old-launch-logs:
	java -Xshare:on \
         -XX:SharedArchiveFile=application.jsa \
         -Xlog:cds \
         -jar the-validation-company/the-validation-company.jar

# Verify CDS
verify-class-loading:
	jcmd build/libs/the-validation-company.jar VM.classloader_stats
verify-cds-logs:
	java -Xlog:cds -jar build/libs/the-validation-company.jar
verify-native-memory:
	jcmd build/libs/the-validation-company.jar VM.native_memory summary
verify-class-loaders:
	jcmd build/libs/the-validation-company.jar VM.classloaders
verify-issued-commands:
	jcmd build/libs/the-validation-company.jar VM.command_line
verify-system-properties:
	jcmd build/libs/the-validation-company.jar VM.system_properties

cds-verify-class-loading:
	jcmd the-validation-company/the-validation-company.jar VM.classloader_stats
cds-verify-cds-logs:
	java -Xshare:on -Xlog:cds -jar the-validation-company/the-validation-company.jar
cds-verify-class-loaders:
	jcmd the-validation-company/the-validation-company.jar VM.classloaders
cds-verify-native-memory:
	jcmd the-validation-company/the-validation-company.jar VM.native_memory summary
cds-verify-issued-commands:
	jcmd the-validation-company/the-validation-company.jar VM.command_line
cds-verify-system-properties:
	jcmd the-validation-company/the-validation-company.jar VM.system_properties

# JLINK experiments
copy-jre-to-local:
	if [ -d traditional/current ]; then rm -rf traditional/current; fi; \
	mkdir -p traditional/current;
	cp -r $(JAVA_HOME)/ traditional/;
jlink-jre:
	if [ -d the-validation-company-jre ]; then rm -rf the-validation-company-jre; fi; \
	jlink --module-path $(JAVA_HOME)/jmods \
          --add-modules java.base,java.logging,java.desktop,java.management,java.naming,java.security.jgss,java.instrument \
          --output the-validation-company-jre; \
    du -sh the-validation-company-jre; \
    the-validation-company-jre/bin/java \
		-Dspring.context.exit=onRefresh \
		-jar build/libs/the-validation-company.jar
docker-delete:
	docker ps -a --format '{{.ID}}' --filter "name=the-validation-company*" | xargs -I {}  docker stop {}
	docker ps -a --format '{{.ID}}' --filter "name=the-validation-company*" | xargs -I {}  docker rm {}
	docker images -a --format '{{.ID}}' --filter "reference=the-validation-company*" | xargs -I {} docker rmi {}
build-jlink-docker-image: jlink-jre
	docker build -t the-validation-company:latest .
build-traditional-docker-image:copy-jre-to-local
	cp build/libs/the-validation-company.jar traditional
	docker build -t the-validation-company-traditional:latest traditional/.
	java \
		-Dspring.context.exit=onRefresh \
		-jar build/libs/the-validation-company.jar
build-jlink-example-images: build-jlink-docker-image build-traditional-docker-image
run-link-docker-image:
	docker run --rm the-validation-company:latest
	docker images --filter "reference=the-validation-company"
run-traditional-docker-image:
	docker run --rm the-validation-company-traditional:latest
	docker images --filter "reference=the-validation-company-traditional"
show-jlink-images:
	docker images --filter "reference=the-validation-company*"
