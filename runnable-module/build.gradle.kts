plugins {
    kotlin("jvm") version "2.2.20"
    java
}

group = "org.jesperancinha.smtd"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(25)
}

java {
    modularity.inferModulePath.set(true)
}
tasks.register<Copy>("copyKotlinStdLib") {
    from(configurations.runtimeClasspath)
    into("build/libs")
    include("*.jar")
}
