SHELL := /bin/bash
GRADLE_VERSION ?= 8.14.3

b:

build-maven:
	mvn clean install
