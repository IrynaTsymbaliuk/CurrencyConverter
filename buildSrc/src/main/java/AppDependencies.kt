// Kotlin DSL dependencies

object AppDependencies {

    // android

    // Compose
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val composeFoundation by lazy { "androidx.compose.foundation:foundation:${Versions.compose}" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3:${Versions.composeMaterial3}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeConstraintLayout by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}" }

    // Google Service
    val googleService by lazy { "com.google.gms:google-services:${Versions.googleService}" }

    // Ktor
    val ktorOkhttp by lazy { "io.ktor:ktor-client-okhttp:${Versions.ktor}" }

    // Koin
    val koinAndroid by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
    val koinCompose by lazy { "io.insert-koin:koin-androidx-compose:${Versions.koin}" }

    // common for android and ios

    // Coroutines
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}" }

    // Firebase
    val firebaseConfigKtx by lazy { "com.google.firebase:firebase-config-ktx:${Versions.firebaseKtx}" }
    val firebaseAnalytics by lazy { "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseKtx}" }

    // Ktor
    val ktorCore by lazy { "io.ktor:ktor-client-core:${Versions.ktor}" }
    val ktorSerialization by lazy { "io.ktor:ktor-client-serialization:${Versions.ktor}" }

    // Koin
    val koinCore by lazy { "io.insert-koin:koin-core:${Versions.koin}" }

}
