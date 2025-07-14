@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion


plugins {
    kotlin("jvm") version libs.versions.kotlin
    `java-library`
}

@Suppress("PropertyName")
val project_version: String by properties

group = "net.llvg"
version = project_version

repositories {
    mavenCentral()
}

@Suppress("UnstableApiUsage")
testing.suites {
    "test"(JvmTestSuite::class) {
        useKotlinTest(libs.versions.kotlin)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
        vendor = JvmVendorSpec.AZUL
    }
    
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    
    withSourcesJar()
    withJavadocJar()
}

kotlin.compilerOptions {
    apiVersion = KotlinVersion.KOTLIN_2_2
    languageVersion = KotlinVersion.KOTLIN_2_2
    
    jvmTarget = JvmTarget.JVM_1_8
    
    freeCompilerArgs.addAll(
        "-Xjvm-expose-boxed",
        "-Xcontext-parameters",
        "-Xnested-type-aliases",
        "-Xallow-kotlin-package",
        "-Xexplicit-api=warning",
        "-Xcontext-sensitive-resolution",
        "-Xwarning-level=NOTHING_TO_INLINE:disabled",
    )
    
    optIn.addAll(
        "kotlin.contracts.ExperimentalContracts",
        "net.llvg.utilities.KotlinInternal"
    )
    
    verbose = true
}