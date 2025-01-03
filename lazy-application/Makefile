include ../Makefile.mk

b: wrapper clean build
wrapper:
	cd ..; \
  	gradle wrapper;
clean:
	if [ -d lazy-application ]; then rm -r lazy-application; fi;
	if [ -d build ]; then rm -r build; fi;
	if [ -f application.jsa ]; then rm application.jsa; fi;
	if [ -f classlist.txt ]; then rm classlist.txt; fi;
	if [ -f loaded-classes.txt ]; then rm loaded-classes.txt; fi;
	if [ -f classes.lst ]; then rm classes.*; fi;
build: clean
	gradle build;
run-gradle:
	gradle bootRun;
run:
	java -XX:+UnlockDiagnosticVMOptions \
         -XX:NativeMemoryTracking=summary \
         -Xlog:startuptime \
		 -jar build/libs/lazy-application.jar

cds-extract:
	java -Djarmode=tools \
		-jar build/libs/lazy-application.jar extract
cds-create-start:
	java -XX:ArchiveClassesAtExit=./application.jsa \
		-Dspring.context.exit=onRefresh \
		-jar lazy-application/lazy-application.jar
	java -Xshare:on \
		 -Xlog:cds=debug:file=cds.log \
		 -XX:+UnlockDiagnosticVMOptions \
		 -XX:SharedArchiveFile=application.jsa -jar lazy-application/lazy-application.jar
cds-create-start2:
	java -Xlog:class+load:file=classes.lst -Dspring.context.exit=onRefresh -jar lazy-application/lazy-application.jar
	java -Xshare:dump -XX:SharedArchiveFile=application.jsa -Dspring.context.exit=onRefresh -cp lazy-application/lazy-application.jar
	java -Xshare:on\
		 -XX:+UnlockDiagnosticVMOptions \
		 -XX:SharedArchiveFile=application.jsa -jar lazy-application/lazy-application.jar
cds-status:
	jcmd lazy-application/lazy-application.jar GC.class_histogram > loaded-classes.txt
cds-list-classes:
	java -XX:SharedArchiveFile=application.jsa -XX:+PrintSharedArchiveAndExit
cds-list-classes-VM:
	jcmd lazy-application/lazy-application.jar VM.classes
trigger:
	curl http://localhost:8080/trigger
