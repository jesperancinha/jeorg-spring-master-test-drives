SHELL := /bin/bash
GRADLE_VERSION ?= 8.13

b:

build-maven:
	mvn clean install
