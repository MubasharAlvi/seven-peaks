plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.sevenpeakssoftware.local"
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
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {

    api(CommonDependencies.core)
    api(CommonDependencies.material)
    api(CommonDependencies.constraintLayout)
    api(CommonDependencies.appcompat)
    api(TestingDependencies.androidJunit)
    api(TestingDependencies.testEspresso)
    kapt(CommonDependencies.hiltKapt)
    kapt(CommonDependencies.hilt)

    api(PersistenceDependencies.runtime)
    api(PersistenceDependencies.ktx)
    kapt(PersistenceDependencies.compiler)
    api(PersistenceDependencies.testing)
    api(TestingDependencies.coroutineTest)
    api(TestingDependencies.androidJunit)
    api(TestingDependencies.googleTruth)
    api(TestingDependencies.archCore)
    api(TestingDependencies.androidxRunner)
    api(TestingDependencies.androidxRunner)
    implementation(project(":shared:data:remote"))
    implementation("org.xerial:sqlite-jdbc:3.44.1.0")
}
kapt {
    correctErrorTypes = true
}
