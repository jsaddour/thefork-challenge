import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc02"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("androidx.appcompat:appcompat:1.4.0")


//Compose
    implementation("androidx.compose.ui:ui:1.0.5")
// Integration with activities
    implementation("androidx.activity:activity-compose:1.4.0")
// Compose Material Design
   implementation("androidx.compose.material:material:1.0.5")
// Animations
     implementation("androidx.compose.animation:animation:1.0.5")
// Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.5")
// Integration with ViewModels
   implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
   implementation("androidx.compose.runtime:runtime-livedata:1.0.5")
    implementation("io.coil-kt:coil-compose:1.3.1")




   implementation("com.google.guava:guava:27.0.1-android")

    implementation("com.google.dagger:hilt-android:2.38.1")
    implementation(project(mapOf("path" to ":api")))
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
}
