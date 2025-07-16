plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.sevenpeakssoftware.core"
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
//        exclude 'META-INF/DEPENDENCIES'
//        exclude 'META-INF/LICENSE'
//        exclude 'META-INF/LICENSE.txt'
//        exclude 'META-INF/license.txt'
//        exclude 'META-INF/NOTICE'
//        exclude 'META-INF/NOTICE.txt'
//        exclude 'META-INF/notice.txt'
        exclude("META-INF/AL2.0")
        exclude("META-INF/*.kotlin_module")
    }
    buildFeatures.dataBinding = true

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
    api(CommonDependencies.coroutineCore)
    api(CommonDependencies.coroutineAndroid)
    api(CommonDependencies.fragmentKtx)
    api(CommonDependencies.runtimeKtx)
    api(CommonDependencies.navigationFragmentKtx)
    api(CommonDependencies.uiKtx)
    api(CommonDependencies.coil)
    api(CommonDependencies.swipe)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.itextpdf:itext7-core:7.1.10")
    implementation(project(":shared:data:local"))
    implementation(project(":shared:data:remote"))
}
