SHELL := /bin/bash
GRADLE_VERSION ?= 8.14.2

b:

build-maven:
	mvn clean install
