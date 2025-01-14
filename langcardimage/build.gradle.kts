import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
    alias(libs.plugins.kmmbridge)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
            publishAllLibraryVariants()
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "langcardimage"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    val LIBRARY_VERSION: String by project

    version = LIBRARY_VERSION
    group = "com.example.langcardkmp"
    namespace = "com.example.langcardkmp"
    compileSdk = 35
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

val  properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())
//
//publishing {
//    repositories {
//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/thanat-arp/LangCardKMP")
//            credentials {
//                username = properties.getProperty("github.user")
//                password = properties.getProperty("github.token")
//            }
//        }
//    }
//}

addGithubPackagesRepository()

kmmbridge {
    gitHubReleaseArtifacts()
    spm()
}