include ../Makefile.mk

b:
	gradle build
	gradle copyKotlinStdLib
run:
	java --module-path build/libs --module runnable.module/org.jesperancinha.smtd.Runnable
inspect:
	jar -tf build/libs/runnable-module.jar
list-modules:
	java --module-path build/libs --list-modules
	jar --describe-module --file build/libs/runnable-module.jar
