plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
	id("com.google.cloud.tools.jib") version "3.3.2"
}

group = "ch.kunkel.well"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

jib {
	from {
		image = "eclipse-temurin:17-jre"
	}
	to {
		// this will automatically push latest
		image = "kunkel/datetracker"
		// add version tag
		tags = mutableSetOf("$version")
	}
	container {
		ports = listOf("8090")
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
