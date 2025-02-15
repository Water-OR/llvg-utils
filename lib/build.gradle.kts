plugins {
        kotlin("jvm") version libs.versions.kotlin
        
        `java-library`
        `maven-publish`
        publishing
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
        val test by getting(JvmTestSuite::class) {
                useKotlinTest(libs.versions.kotlin)
        }
}

java {
        toolchain {
                languageVersion = JavaLanguageVersion.of(8)
                vendor = JvmVendorSpec.AZUL
        }
        
        withSourcesJar()
        withJavadocJar()
}

kotlin {
        compilerOptions {
                val args = listOf(
                        "-Xjvm-default=all"
                )
                freeCompilerArgs.addAll(args)
        }
}

publishing {
        repositories {
                mavenLocal()
        }
        
        publications {
                val maven by registering(MavenPublication::class) {
                        from(components["kotlin"])
                        artifact(tasks["sourcesJar"])
                        artifact(tasks["javadocJar"])
                        pom {
                                artifactId = "loli-utils"
                                name = "loli-utils"
                                description = "LolI Vanguard's utils <3"
                                url = "https://github.com/Water-OR/llvg-utils"
                        }
                }
        }
}