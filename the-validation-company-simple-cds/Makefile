include ../Makefile.mk

b: wrapper clean build
wrapper:
	cd ..; \
  	gradle wrapper;
clean:
	if [ -d build ]; then rm -r build; fi;
build: clean
	gradle build;
run:
	java -jar build/libs/the-validation-company-simple-cds.jar --keep
verify-cds:
	find ~/.sdkman/ -name "classes.jsa"

# CDS
cds-class-list:
	java -Xshare:off -XX:DumpLoadedClassList=classlist.txt -cp build/libs/the-validation-company-simple-cds.jar nl.coin.smtd.Main
cds-archive:
	java -Xshare:dump \
         -XX:SharedClassListFile=classlist.txt \
         -XX:SharedArchiveFile=application.jsa \
         -cp build/libs/the-validation-company-simple-cds.jar
cds-launch:
	java -Xshare:on \
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