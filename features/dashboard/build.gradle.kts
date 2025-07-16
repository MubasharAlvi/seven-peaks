plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("kotlinx-serialization")

}

android {
    namespace = "com.sevenpeakssoftware.dashboard"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("ETA-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
    buildFeatures.dataBinding=true

}

dependencies {
    api(CommonDependencies.core)
    api(CommonDependencies.material)
    api(CommonDependencies.constraintLayout)
    api(CommonDependencies.appcompat)
    api(TestingDependencies.androidJunit)
    api(TestingDependencies.testEspresso)
    kapt(CommonDependencies.hiltKapt)
    api(CommonDependencies.hilt)
    androidTestImplementation(CommonDependencies.hiltGoogle)
    kaptAndroidTest(CommonDependencies.hiltKaptGoogle)
    api(CommonDependencies.carerock_svg)
    api(CommonDependencies.coil)
    api(CommonDependencies.lifecycleViewModel)
    api(CommonDependencies.glide)
    annotationProcessor(CommonDependencies.glidePro)
    //testing
    testImplementation(TestingDependencies.junit)
    testImplementation(TestingDependencies.coroutineTest)
    androidTestImplementation(TestingDependencies.coroutineTest)
    testImplementation(TestingDependencies.googleTruth)
    androidTestImplementation(TestingDependencies.googleTruth)
    androidTestImplementation(TestingDependencies.mockito)
    androidTestImplementation(TestingDependencies.androidJunit)
    testImplementation(TestingDependencies.archCore)
    androidTestImplementation(TestingDependencies.archCore)
    androidTestImplementation(TestingDependencies.androidxRunner)
    testImplementation(TestingDependencies.testCore)
    testImplementation(TestingDependencies.mockServer)
    androidTestImplementation(TestingDependencies.mockServer)
    testImplementation(TestingDependencies.mockitos)

    implementation(project(":shared:data:local"))
    implementation(project(":shared:data:remote"))
    implementation(project(":shared:navigation"))
    implementation(project(":shared:core"))
}