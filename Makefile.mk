SHELL := /bin/bash
GRADLE_VERSION ?= 9.2.0

b:

build-maven:
	mvn clean install
