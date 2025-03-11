plugins {
	java
	id("org.springframework.boot") version "3.3.9"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.sonarqube") version "6.0.1.5171"
}

group = "com.cantech.batch"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

sonar {
	properties {
		property("sonar.projectKey", "batch-service")
		property("sonar.projectName", "batch-service")
	}
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")

	// Lombok (컴파일 타임 전용)
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// Lombok (테스트 환경)
	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")

	// Spring Cloud Config
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	testImplementation("com.h2database:h2")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
