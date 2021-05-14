/**
 * 版本信息
 */
interface Versions {

    def compileSDK = 30 // 编译SDK版本
    def buildTools = "30.0.3" // Gradle编译项目工具版本

    def minSDK = 21 // 最低兼容Android版本
    def targetSDK = 30 // 最高兼容Android版本
}

interface Dependencies {

    // 插件 ClassPath
    def androidGradle = "com.android.tools.build:gradle:3.4.1"
    def kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32"

    // 基本配置
    def kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.4.32"
    def coreKtx = "androidx.core:core-ktx:1.3.2"
    def appcompat = "androidx.appcompat:appcompat:1.2.0"
    def material = "com.google.android.material:material:1.2.1"
    def constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

    // 测试项
    def junit = "junit:junit:4.13.2"
    def junitExt = "androidx.test:runner:1.3.0"
    def espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

    ////////////////////  Kotlin  Begin  ////////////////////
    // Coroutines 协程
    def kotlinCoroutinesCore = 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9'
    def kotlinCoroutinesAndroid = 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'
    def kotlinCoroutinesTest = 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.7'
    ////////////////////  Kotlin  End  ////////////////////

    ////////////////////  Android ktx  Begin  ////////////////////
    // fragment
    def fragmentKtx = 'androidx.fragment:fragment-ktx:1.2.5'

    // navigation
    def navigationFragmentKtx = 'androidx.navigation:navigation-fragment-ktx:2.3.2'
    def navigationUiKtx = 'androidx.navigation:navigation-ui-ktx:2.3.2'

    // recyclerView
    def recyclerView = 'androidx.recyclerview:recyclerview:1.1.0'
    def recyclerViewSelection = 'androidx.recyclerview:recyclerview-selection:1.1.0-rc03'

    // swipeRefreshLayout
    def swipeRefreshLayout = 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'

    // lifecycle
    def lifecycleExt = 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    def lifecycleRuntimeKtx = 'androidx.lifecycle:lifecycle-runtime-ktx:2.2.0'
    def lifecycleCommonJava8 = 'androidx.lifecycle:lifecycle-common-java8:2.2.0'
    def lifecycleViewModelKtx = 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
    def lifecycleLiveDataKtx = 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'

    // room
    def roomRuntime = "androidx.room:room-runtime:2.2.5"
    def roomCompiler = "androidx.room:room-compiler:2.2.5"
    // optional - Kotlin Extensions and Coroutines support for Room
    def roomKtx = "androidx.room:room-ktx:2.2.5"
    // optional - Test helpers
    def roomTesting = "androidx.room:room-testing:2.2.5"
    ////////////////////  Android ktx  End  ////////////////////

    ////////////////////  June的三方库  Begin  ////////////////////
    def juneVersion = "0.0.1"
    def juneComponent = "com.june.base:component:$juneVersion"
    def juneNetwork = "com.june.function:network:$juneVersion"
    def juneLoading = "com.june.widget:loading:$juneVersion"
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
    ////////////////////  第三方类库  End  ////////////////////
}