SHELL := /bin/bash
GRADLE_VERSION ?= 9.2.1

b:

build-maven:
	mvn clean install
