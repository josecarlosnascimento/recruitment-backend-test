pluginManagement {
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val graalvmNativeVersion: String by settings
    val ktlintVersion: String by settings
    val sonarqubeVersion: String by settings

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        id("org.graalvm.buildtools.native") version graalvmNativeVersion
        id("org.jlleitschuh.gradle.ktlint") version ktlintVersion
        id("org.sonarqube") version sonarqubeVersion
        jacoco
    }
}

rootProject.name = "recruitment-financial-service"
