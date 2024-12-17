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
run:
	gradle bootRun;

# Spring CDS ---

cds-extract:
	java -Djarmode=tools -jar build/libs/the-validation-company.jar extract
cds-archive:
	java -XX:ArchiveClassesAtExit=./application.jsa \
		-Dspring.context.exit=onRefresh \
		-jar the-validation-company/the-validation-company.jar
cds-launch:
	java -XX:SharedArchiveFile=application.jsa \
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
