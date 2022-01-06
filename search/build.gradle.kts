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
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    implementation(project(":api"))

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:+")


    testImplementation("junit:junit:4.13.2")

    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation( "androidx.lifecycle:lifecycle-process:2.3.1")
    implementation( "androidx.lifecycle:lifecycle-compiler:2.3.1")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")


     val MOCKK = "1.11.0"
     val ASSERTJ = "3.19.0"
     val JUNIT = "4.13.2"
     val JUNIT_PARAMS = "1.1.1"


    testImplementation( "org.mockito:mockito-core:+")
    testImplementation( "io.mockk:mockk:${MOCKK}")
    testImplementation( "org.assertj:assertj-core:${ASSERTJ}")
    testImplementation( "junit:junit:${JUNIT}")
    testImplementation( "org.jetbrains.kotlin:kotlin-test-junit:+")
    testImplementation( "pl.pragmatists:JUnitParams:${JUNIT_PARAMS}")


}



