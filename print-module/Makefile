include ../Makefile.mk

b:
	gradle build
	gradle copyKotlinStdLib
run:
	java --module-path build/libs --module jesperancinha.module/org.jesperancinha.smtd.PrintModuleStarterKt
inspect:
	jar -tf build/libs/print-module.jar
list-modules:
	java --module-path build/libs --list-modules
