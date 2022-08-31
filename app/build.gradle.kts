/*
 * MIT License
 *
 * Copyright (c) 2021 码上夏雨
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.gcode.plugin.version.*

plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.gcode.plugin.version")
}

android {
    compileSdk = Version.compile_sdk_version
    buildToolsVersion = Version.build_tools_version

    defaultConfig {
        applicationId = "com.gcode.imaker"
        minSdk = Version.min_sdk_version
        targetSdk = Version.target_sdk_version
        versionCode = Version.version_code
        versionName = Version.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")
}

dependencies {
    kapt("com.android.databinding:compiler:4.0.1")

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation(files("libs/VastTools_0.0.9_Cancey.jar"))

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.recyclerview)
    implementation(AndroidX.constraintlayout)
    implementation(AndroidX.annotation)
    implementation(AndroidX.version_lifecycle_viewmodel_ktx)
    implementation(AndroidX.version_lifecycle_livedata_ktx)
    androidTestImplementation(AndroidX.junit)
    androidTestImplementation(AndroidX.espresso_core)

    implementation(Google.material)
    implementation(Google.accompanist_coil)
    implementation(Google.accompanist_insets)
    implementation(Google.accompanist_insets_ui)
    implementation(Google.accompanist_systemuicontroller)

    implementation(Compose.compose_activity)
    implementation(Compose.compose_material)
    implementation(Compose.compose_animation)
    implementation(Compose.compose_ui_tooling)
    implementation(Compose.compose_lifecycle_viewmodel)
    implementation(Compose.compose_runtime_livedata)
    implementation(Compose.compose_constraintlayout)
    implementation(Compose.compose_nav_version)
    androidTestImplementation(Compose.compose_ui_test_junit4)

    testImplementation(Libraries.junit)
}