buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

plugins {
    jacoco
    java
    id( "org.jesperancinha.plugins.omni") version "0.4.5"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
