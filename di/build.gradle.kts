plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")

}

android {
    namespace = "com.sevenpeakssoftware.di"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

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
}

dependencies {
    api(CommonDependencies.core)
    api(CommonDependencies.material)
    api(CommonDependencies.constraintLayout)
    api(TestingDependencies.junit)
    api(CommonDependencies.appcompat)
    api(TestingDependencies.androidJunit)
    api(TestingDependencies.testEspresso)
    kapt(CommonDependencies.hiltKapt)
    api(CommonDependencies.hilt)
    androidTestImplementation(CommonDependencies.hiltGoogle)
    kaptAndroidTest(CommonDependencies.hiltKaptGoogle)

    implementation(project(":shared:core"))
    implementation(project(":features:dashboard"))
    implementation(project(":shared:data:local"))
    implementation(project(":shared:data:remote"))
    implementation(project(":shared:navigation"))
}