SHELL := /bin/bash
GRADLE_VERSION ?= 9.0.0

b:

build-maven:
	mvn clean install
