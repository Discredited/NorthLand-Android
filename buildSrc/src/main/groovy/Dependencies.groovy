/**
 * 版本信息
 */
interface Versions {

    def compileSDK = 31 // 编译SDK版本
    def buildTools = "30.0.2" // Gradle编译项目工具版本

    def minSDK = 21 // 最低兼容Android版本
    def targetSDK = 30 // 最高兼容Android版本
}

interface Dependencies {

    // 插件 ClassPath
    def kotlin_version = "1.5.20"
    def androidGradle = "com.android.tools.build:gradle:7.0.0"
    def kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}"

    // 基本配置
    def kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlin_version}"
    def kotlinAndroidExtensionsRuntime = "org.jetbrains.kotlin:kotlin-android-extensions-runtime:${kotlin_version}"
    def coreKtx = "androidx.core:core-ktx:1.7.0"
    def appcompat = "androidx.appcompat:appcompat:1.4.1"
    def material = "com.google.android.material:material:1.5.0"
    def constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

    // 测试项
    def junit = "junit:junit:4.13.2"
    def junitExt = "androidx.test:runner:1.3.0"
    def espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

    ////////////////////  Kotlin  Begin  ////////////////////
    // Coroutines 协程
    def kotlinCoroutinesCore = 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0'
    def kotlinCoroutinesAndroid = 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0'
    def kotlinCoroutinesTest = 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.7'
    ////////////////////  Kotlin  End  ////////////////////

    ////////////////////  Android ktx  Begin  ////////////////////
    // fragment
    def fragmentKtx = 'androidx.fragment:fragment-ktx:1.2.5'

    // navigation
    def navigationFragmentKtx = 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    def navigationUiKtx = 'androidx.navigation:navigation-ui-ktx:2.3.5'

    // recyclerView
    def recyclerView = 'androidx.recyclerview:recyclerview:1.2.1'
    def recyclerViewSelection = 'androidx.recyclerview:recyclerview-selection:1.2.0-alpha01'

    // swipeRefreshLayout
    def swipeRefreshLayout = 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'

    // lifecycle
    def lifecycle_version = "2.5.0-alpha02"
    def lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycle_version}"
    def lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${lifecycle_version}"
    def lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}"
    def lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${lifecycle_version}"

    // room
    def room_version = "2.3.0"
    def roomRuntime = "androidx.room:room-runtime:${room_version}"
    def roomCompiler = "androidx.room:room-compiler:${room_version}"
    // optional - Kotlin Extensions and Coroutines support for Room
    def roomKtx = "androidx.room:room-ktx:${room_version}"
    // optional - Test helpers
    def roomTesting = "androidx.room:room-testing:${room_version}"
    ////////////////////  Android ktx  End  ////////////////////

    ////////////////////  June的三方库  Begin  ////////////////////
    def juneVersion = "0.0.2"
    def juneComponent = "com.june.base:component:$juneVersion"
    def juneNetwork = "com.june.function:network:$juneVersion"
    def juneLoading = "com.june.widget:loading:$juneVersion"
    def juneExplosion = "com.june.widget:explosion:$juneVersion"

    def nlVersion = "0.0.1"
    def nlComponent = "com.nl.base:component:$nlVersion"
    ////////////////////  June的三方库  End  ////////////////////

    ////////////////////  第三方类库  Begin  ////////////////////
    // Timber 日志
    def timber = "com.jakewharton.timber:timber:4.7.1"

    // AndroidUtils
    def androidUtils = "com.blankj:utilcodex:1.30.6"

    // OkHttp
    def okHttp = "com.squareup.okhttp3:okhttp:4.9.1"
    def okHttpLogging = "com.squareup.okhttp3:logging-interceptor:4.9.1"

    // Retrofit
    def retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    def retrofitConvertGson = "com.squareup.retrofit2:converter-gson:2.9.0"
    def retrofitAdapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"

    // Glide
    def glide = "com.github.bumptech.glide:glide:4.11.0"
    def glideCompiler = "com.github.bumptech.glide:compiler:4.11.0"
    def glideIntegration = "com.github.bumptech.glide:okhttp3-integration:4.11.0"

    // RxJava2
    def rxJava = "io.reactivex.rxjava2:rxjava:2.2.14"
    def rxJavaAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    // BaseRecyclerViewAdapterHelper
    def quickAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"

    // ARouter
    def aRouter = "com.alibaba:arouter-api:1.5.2"
    def aRouterCompiler = "com.alibaba:arouter-compiler:1.5.2"
    ////////////////////  第三方类库  End  ////////////////////
}