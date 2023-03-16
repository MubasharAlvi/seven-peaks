object Apps {
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val gradle = "3.5.0"
    const val kotlin = "1.4.10"
    const val appcompat = "1.6.1"
    const val core = "1.9.0"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"

    /* test */
    const val junit = "4.13.2"
    const val test_ext_junit = "1.1.5"
    const val test_espresso = "3.5.1"
    const val room_version = "2.3.0"
    const val hilt_version = "2.39.1"
    const val android_core_version = "1.7.0"
    const val app_compat_version = "1.4.1"
    const val material_version = "1.5.0"
    const val constraint_version = "2.1.3"
    const val expresso_version = "3.4.0"
    const val coroutine_version = "1.5.2"
    const val ktx_version = "2.3.5"
    const val fragment_ktx_version = "1.3.6"
    const val retrofit_version = "2.9.0"
    const val kotlin_serialization_version = "1.3.2"
    const val logging_interceptor_version = "4.9.3"
    const val kotlinx_converter_version = "0.8.0"
    const val androidx_lifecycle_version = "2.4.1"
    const val coil = "1.4.0"
    const val runtime_ktx_version = "2.4.1"
    const val swipe_version = "1.1.0"
    const val gson="2.8.9"
    const val gsonRetrofit="2.9.0"
    const val caverock = "1.4"

    //testing versions
    const val junit_version = "4.13.2"
    const val android_junit_version = "1.1.3"
    const val truth_version = "1.0.1"
    const val turbine_version = "0.4.0"
    const val mockito_version = "1.12.2"
    const val arch_core_version = "2.1.0"
    const val android_runner_version = "1.4.0"
    const val test_core_version = "1.4.0"
    const val mock_server_version = "4.9.0"
}


object TestingDependencies {
    const val junit = "junit:junit:${Versions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.test_ext_junit}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.test_espresso}"
    const val googleTruth = "com.google.truth:truth:${Versions.truth_version}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_version}"
    const val mockito = "io.mockk:mockk-android:${Versions.mockito_version}"
    const val mockitos = "io.mockk:mockk:${Versions.mockito_version}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.android_junit_version}"
    const val archCore = "androidx.arch.core:core-testing:${Versions.arch_core_version}"
    const val androidxRunner = "androidx.test:runner:${Versions.android_runner_version}"
    const val testCore = "androidx.test:core:${Versions.test_core_version}"
    const val mockServer = "com.squareup.okhttp3:mockwebserver:${Versions.mock_server_version}"
}

object CommonDependencies {
    const val androidCore = "androidx.core:core-ktx:${Versions.android_core_version}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    const val hilt= "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hiltKapt= "com.google.dagger:hilt-compiler:${Versions.hilt_version}"
    const val hiltGoogle ="com.google.dagger:hilt-android-testing:${Versions.hilt_version}"
    const val hiltKaptGoogle= "com.google.dagger:hilt-android-compiler:${Versions.hilt_version}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_version}"
    const val expresso = "androidx.test.espresso:espresso-core:${Versions.expresso_version}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_version}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.ktx_version}"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.ktx_version}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx_version}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val runtimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtime_ktx_version}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_lifecycle_version}"
    const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipe_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val glide ="com.github.bumptech.glide:glide:4.14.2"
    const val glidePro  =  "com.github.bumptech.glide:compiler:4.14.2"
    const val carerock_svg = "com.caverock:androidsvg-aar:${Versions.caverock}"

}

object NetworkingDependencies {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlin_serialization_version}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor_version}"
    const val kotlinxConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinx_converter_version}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonRe = "com.squareup.retrofit2:converter-gson:${Versions.gsonRetrofit}"

}

object PersistenceDependencies {
    const val runtime = "androidx.room:room-runtime:${Versions.room_version}"
    const val ktx = "androidx.room:room-ktx:${Versions.room_version}"
    const val compiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val testing = "androidx.room:room-testing:${Versions.room_version}"
}
