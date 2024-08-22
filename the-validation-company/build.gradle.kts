plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("jvm") version "2.0.10"
	kotlin("plugin.spring") version "2.0.20"
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
	runtimeOnly("io.kotest:kotest-assertions-core:5.9.1")
	testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
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