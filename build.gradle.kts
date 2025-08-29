plugins {
	java
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "org.jpetto"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// 기본 스프링 세팅
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")

	// Oauth2
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

	// google api 호출 및 calender api
	implementation("com.google.api-client:google-api-client:1.35.2")
	implementation("com.google.apis:google-api-services-calendar:v3-rev20220715-2.0.0")
	implementation("com.google.auth:google-auth-library-oauth2-http:1.19.0")

	// Swagger UI
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
