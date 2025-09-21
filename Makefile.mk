SHELL := /bin/bash
GRADLE_VERSION ?= 9.1.0

b:

build-maven:
	mvn clean install
