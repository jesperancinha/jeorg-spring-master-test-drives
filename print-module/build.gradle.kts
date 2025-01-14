plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.jesperancinha.smtd"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
java {
    modularity.inferModulePath.set(true)
}
tasks.register<Copy>("copyKotlinStdLib") {
    from(configurations.runtimeClasspath)
    into("build/libs")
    include("*.jar")
}