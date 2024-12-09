plugins {
    alias(libs.plugins.jesperancinha.omni)
    alias(libs.plugins.kotlin.jvm)
    jacoco
}

group = "nl.coin.smtd"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}