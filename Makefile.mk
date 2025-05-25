SHELL := /bin/bash
GRADLE_VERSION ?= 8.14.1

b:

build-maven:
	mvn clean install
