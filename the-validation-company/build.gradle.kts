plugins {
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.jesperancinha.omni)
	jacoco
}

group = "org.jesperancinha"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly(libs.kotest.assertions.core.jvm)
	testImplementation(libs.kotest.runner.junit5)
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		setExceptionFormat("full")
		events ("started", "skipped", "passed", "failed")
		showStandardStreams = true
	}
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}

kotlin {
	jvmToolchain(11)
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
