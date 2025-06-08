import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21"
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.graalvm.buildtools.native")
    id("org.jlleitschuh.gradle.ktlint")
    jacoco
}

group = "br.com.recruitment.service"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

sourceSets {
    named("main") {
        java.srcDir("build/generated/main/java")
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://packages.confluent.io/maven/") }
}

dependencies {
    // Core dependencies
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Jakarta dependencies
    implementation("jakarta.persistence:jakarta.persistence-api")

    // Database dependencies
    implementation("org.liquibase:liquibase-core:${property("liquibaseVersion")}")
    runtimeOnly("com.mysql:mysql-connector-j:${property("mysqlConnectorVersion")}")

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:${properties["mokitoKotlinVersion"]}")
    testImplementation("org.mockito:mockito-core:${properties["mockitoCoreVersion"]}")
    testImplementation("org.mockito:mockito-inline:${properties["mockitoInlineVersion"]}")
    testImplementation("net.datafaker:datafaker:${properties["dataFakerVersion"]}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    jvmArgs("-XX:+EnableDynamicAgentLoading", "-Xshare:off")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_21)
        apiVersion.set(KotlinVersion.KOTLIN_2_0)
        javaParameters.set(true)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}

jacoco {
    toolVersion = "${properties["jacocoVersion"]}"
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}

val excludeRulesDir =
    project.files().map { dir ->
        fileTree(
            mapOf(
                "dir" to dir,
                "exclude" to
                    listOf(
                        "**/*exception/*",
                        "**/*config/*",
                        "**/*controllers/*",
                        "**/domain/*",
                        "**/*repository/*",
                        "**/*utils/*",
                    ),
            ),
        )
    }

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        html.outputLocation.set(layout.buildDirectory.dir("jacoco/test/html"))
    }

    classDirectories.setFrom(excludeRulesDir)
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)

    classDirectories.setFrom(excludeRulesDir)

    violationRules {
        rule {
            limit {
                minimum = BigDecimal.valueOf(0.9)
            }
        }
    }
}

tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}
