// 统一版本声明
object Versions {
    const val compileSDK = 31 // 编译SDK版本
    const val buildTools = "31.0.0" // Gradle编译项目工具版本

    const val minSDK = 21 // 最低兼容Android版本
    const val targetSDK = 31 // 最高兼容Android版本

    const val kotlin_version = "1.7.22"
}

// 插件 ClassPath
object Plugins {
    const val androidGradle = "com.android.tools.build:gradle:7.0.0"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
}

// 依赖声明
object Dependencies {

    // 基本配置
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    const val kotlinAndroidExtensionsRuntime = "org.jetbrains.kotlin:kotlin-android-extensions-runtime:${Versions.kotlin_version}"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val appcompat = "androidx.appcompat:appcompat:1.4.1"
    const val material = "com.google.android.material:material:1.5.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

    // 测试项
    const val junit = "junit:junit:4.13.2"
    const val junitExt = "androidx.test:runner:1.3.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

    ////////////////////  Kotlin  Begin  ////////////////////
    // Coroutines 协程
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    ////////////////////  Kotlin  End  ////////////////////

    ////////////////////  Android ktx  Begin  ////////////////////
    // fragment
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.1"

    // navigation
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.3.5"

    // recyclerView
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
    const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:1.2.0-alpha01"

    // swipeRefreshLayout
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    // lifecycle
    private const val lifecycle_version = "2.5.0-alpha02"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycle_version}"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${lifecycle_version}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${lifecycle_version}"

    // room
    private const val room_version = "2.4.3"
    const val roomRuntime = "androidx.room:room-runtime:${room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${room_version}"
    // optional - Kotlin Extensions and Coroutines support for Room
    const val roomKtx = "androidx.room:room-ktx:${room_version}"
    // optional - Test helpers
    const val roomTesting = "androidx.room:room-testing:${room_version}"

    // 照相机
    // The following line is optional, as the core library is included indirectly by camera-camera2
    const val cameraCode = "androidx.camera:camera-core:1.0.2"
    const val camera2 = "androidx.camera:camera-camera2:1.0.2"

    // If you want to additionally use the CameraX Lifecycle library
    const val cameraLifecycle = "androidx.camera:camera-lifecycle:1.0.2"

    const val cameraView = "androidx.camera:camera-view:1.0.0-alpha30"
    const val cameraExtensions = "androidx.camera:camera-extensions:1.0.0-alpha30"
    ////////////////////  Android ktx  End  ////////////////////


    ////////////////////  June的三方库  Begin  ////////////////////
    const val juneVersion = "0.0.2"
    const val juneComponent = "com.june.base:component:$juneVersion"
    const val juneNetwork = "com.june.function:network:$juneVersion"
    const val juneLoading = "com.june.widget:loading:$juneVersion"
    const val juneExplosion = "com.june.widget:explosion:$juneVersion"

    const val nlVersion = "0.0.1"
    const val nlComponent = "com.nl.base:component:$nlVersion"
    ////////////////////  June的三方库  End  ////////////////////

    ////////////////////  第三方类库  Begin  ////////////////////
    // Timber 日志
    const val timber = "com.jakewharton.timber:timber:4.7.1"

    // AndroidUtils
    const val androidUtils = "com.blankj:utilcodex:1.31.0"

    const val mmkv = "com.tencent:mmkv:1.2.13"

    // OkHttp
    const val okHttp = "com.squareup.okhttp3:okhttp:4.9.3"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    const val okio = "com.squareup.okio:okio:3.0.0"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val retrofitConvertGson = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val retrofitAdapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"

    /**
     * Glide
     * https://github.com/bumptech/glide
     */
    const val glide = "com.github.bumptech.glide:glide:4.13.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:4.13.0"
    const val glideIntegration = "com.github.bumptech.glide:okhttp3-integration:4.13.0"

    // RxJava2
    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.14"
    const val rxJavaAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    /**
     * Immersion Bar 沉浸式状态栏
     * https://github.com/gyf-dev/ImmersionBar
     */
    const val immersionBar = "com.geyifeng.immersionbar:immersionbar:3.2.1"
    const val immersionBarKtx = "com.geyifeng.immersionbar:immersionbar-ktx:3.2.1"  // kotlin扩展（可选）


    // ARouter
    const val aRouter = "com.alibaba:arouter-api:1.5.2"
    const val aRouterCompiler = "com.alibaba:arouter-compiler:1.5.2"

    /**
     * PhotoView
     */
    const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"


    const val quickAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"
    ////////////////////  第三方类库  End  ////////////////////
}