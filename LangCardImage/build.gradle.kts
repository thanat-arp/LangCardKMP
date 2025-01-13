import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
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
    
    val xcf = XCFramework("LangCardImage")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "LangCardImage"
            xcf.add(this)
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
    version = "0.0.1"
    group = "com.example.langcardimage"
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://github.com/Thanat-Arpornrat/LangCardKMP.git")
            credentials {
                username = providers.environmentVariable("GITHUB_USER").get()
                password = providers.environmentVariable("GITHUB_TOKEN").get()
            }
        }
    }
}
