plugins {
    alias(libs.plugins.jesperancinha.omni)
    alias(libs.plugins.kotlin.jvm)
    jacoco
    application
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

application {
    mainClass.set("nl.coin.smtd.MainKt")
}

kotlin {
    jvmToolchain(21)
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
