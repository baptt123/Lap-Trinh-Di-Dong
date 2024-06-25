
plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.appnghenhac"
    compileSdk = 34

    defaultConfig { 
        applicationId = "com.example.appnghenhac"
        /*
        minSdk=22 là của project mình
        tôi chỉnh sửa để thêm thư viện firebase auth
        mọi người khi lấy code nhớ chỉnh lại là 22 hoặc để 23 để chạy không bị lỗi nha
         */
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.media3:media3-session:1.3.1")
    // https://mvnrepository.com/artifact/com.google.firebase/firebase-auth
    implementation("com.google.firebase:firebase-auth:21.2.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
    implementation("com.google.firebase:firebase-database")
    implementation("androidx.media3:media3-session:1.3.1")
    implementation("androidx.media:media:1.7.0")
    implementation("androidx.media3:media3-ui:1.3.1")
   implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
//    implementation ("com.android.support:recyclerview-v7:27.1.1")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("androidx.core:core:1.9.0")
// menu
    implementation ("com.google.android.material:material:1.9.0")
//
    implementation("com.google.firebase:firebase-storage")
    implementation ("com.squareup.picasso:picasso:2.71828")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.google.firebase:firebase-analytics:20.0.0")
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation("androidx.core:core-ktx:1.9.0")
}

