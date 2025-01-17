SHELL := /bin/bash
GRADLE_VERSION ?= 8.10.2

b:

build-maven:
	mvn clean install
