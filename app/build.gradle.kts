plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))

kapt.correctErrorTypes = true

android {
    namespace = "com.glovoapp.uabformacions.tmdb"

    compileSdk = libs.versions.android.compileSDK.get().toInt()
    defaultConfig.minSdk = libs.versions.android.minSDK.get().toInt()
}

dependencies {
    // Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // AndroidX Jetpack Libraries
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.uiToolingPreview)
    debugImplementation(libs.androidx.compose.uiTooling)

    // Image Loading
    implementation(libs.coil.compose)
    implementation(libs.coil.network)

    // Networking
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.logging)

    // Kotlin Libraries
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.serialization.json)

    // Retrofit and Serialization
    implementation(libs.retrofit.serialization)

    // Testing Libraries
    testImplementation(libs.androidx.compose.junit4)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.testing.mockk)
}
