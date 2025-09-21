plugins {
    alias(libs.plugins.jesperancinha.omni)
    alias(libs.plugins.kotlin.jvm)
    jacoco
    application
}

group = "org.jesperancinha.smtd"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.jesperancinha.smtd.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.jesperancinha.smtd.SimpleCdsApplication"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}

kotlin {
    jvmToolchain(25)
}

sourceSets {
    main {
        kotlin {
            srcDir("src/main/kotlin")
        }
    }
    test {
        kotlin {
            srcDir("src/test/kotlin")
        }
    }
}
tasks.register("prepareKotlinBuildScriptModel"){}
