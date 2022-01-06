import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}



android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.thefork.challenge"
        minSdk = 21
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("androidx.appcompat:appcompat:1.4.0")

    implementation(project(":search"))
    implementation(project(mapOf("path" to ":user")))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
}

kapt {
    correctErrorTypes = true
}
