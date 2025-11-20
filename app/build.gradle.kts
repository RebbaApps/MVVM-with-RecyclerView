plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mvvm_with_recyclerview"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mvvm_with_recyclerview"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    implementation(libs.cardview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Or the latest stable version
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
// Or the latest stable version
    implementation("com.google.code.gson:gson:2.10.1")
    // Or the latest stable version of Gson itself
}