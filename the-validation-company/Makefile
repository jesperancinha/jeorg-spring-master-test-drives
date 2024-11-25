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
