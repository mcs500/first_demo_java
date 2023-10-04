plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.mcs"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_HIGHER
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	runtimeOnly ("org.postgresql:postgresql")
	implementation ("org.mapstruct:mapstruct:1.5.5.Final")

//	implementation("io.springfox:springfox-swagger2:2.7.6")
//	implementation("io.springfox:springfox-swagger-ui:2.7.6")

	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")


	/*implementation ("io.springfox:springfox-swagger2:3.0.0")
	implementation ("io.springfox:springfox-boot-starter:3.0.0")
	implementation ("io.springfox:springfox-swagger-ui:3.0.0")
	compileOnly ("io.springfox:springfox-swagger-ui:3.0.0")*/

	annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
