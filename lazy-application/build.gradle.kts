plugins {
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.jesperancinha.omni)
	alias(libs.plugins.kotlin.jvm)
	jacoco
}

group = "org.jesperancinha.smtd"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register("prepareKotlinBuildScriptModel"){}
tasks.register("wrapper"){}
tasks.bootJar {
	archiveFileName.set("lazy-application.jar")
}