plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.tsymbaliuk.currency.converter.android"
    compileSdk = AppConfig.compileSdkVersion
    defaultConfig {
        applicationId = "com.tsymbaliuk.currency.converter.android"
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtension
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    // Compose
    implementation(AppDependencies.composeUi)
    implementation(AppDependencies.composeUiTooling)
    implementation(AppDependencies.composeUiToolingPreview)
    implementation(AppDependencies.composeFoundation)
    implementation(AppDependencies.composeMaterial3)
    implementation(AppDependencies.composeActivity)
    implementation(AppDependencies.composeConstraintLayout)

    // Firebase
    implementation(AppDependencies.firebaseConfigKtx)
    implementation(AppDependencies.firebaseAnalytics)

    //Coroutines
    implementation(AppDependencies.kotlinCoroutines)

    // Koin
    implementation(AppDependencies.koinAndroid)
    implementation(AppDependencies.koinCompose)

}