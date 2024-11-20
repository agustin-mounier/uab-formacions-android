plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))

kapt.correctErrorTypes = true

android {
    namespace = "com.glovoapp.uabformacions.tmdb.domain"

    compileSdk = libs.versions.android.compileSDK.get().toInt()
    defaultConfig.minSdk = libs.versions.android.minSDK.get().toInt()
}

dependencies {
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}