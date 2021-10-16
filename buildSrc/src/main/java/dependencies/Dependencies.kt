package dependencies

/**
 * Created at Mahmoud Gamal on 3/13/19
 *
 * Dependencies that will be used in build.gradle file for each module.
 */

object Dependencies {

    //Root gradle plugins
    const val AndroidGradlePlugin =
        "com.android.tools.build:gradle:${Config.androidGradlePlugin}"

    const val JetbrainsKotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.JetbrainsKotlinPlugin}"

    const val HiltPlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Config.HiltPlugin}"

    const val AppCompact =
        "androidx.appcompat:appcompat:${Versions.AndroidX.main}"


    val AndroidXCore = arrayOf(
        "androidx.core:core:${Versions.AndroidX.main}",
        "androidx.core:core-ktx:${Versions.AndroidX.main}"
    )

    val AndroidXLibs = arrayOf(
        // Android Annotation
        "androidx.annotation:annotation:${Versions.AndroidX.main}",

        // MultiDex
        "androidx.multidex:multidex:${Versions.AndroidX.multiDex}",

        // ConstraintLayout
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}",

        // Android Material
        "com.google.android.material:material:${Versions.AndroidX.material}",

        "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragmentKTX}"

    )

    val AndroidArchComponent = arrayOf(
        "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifeCycle}",
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.AndroidX.lifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifeCycle}"
    )

    const val LifeCycleAnnotations =
        "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.lifeCycle}"

    val Testing = arrayOf(
        // Android Unit Testing
//        "androidx.test:runner:${Versions.Testing.runner}",
        // Mockito
        "org.mockito:mockito-core:${Versions.Testing.mockito}",

        // JUnit
        "junit:junit:${Versions.Testing.junit}"
    )

    val AndroidTesting = arrayOf(
        "androidx.test.ext:junit:${Versions.Testing.androidXRunner}",
        "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}"
    )

    const val Kotlin =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.std}"
    const val KotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.std}"


    val CoroutinesCore = arrayOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.std}"
    )

    val CoroutinesAndroid = arrayOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.std}"
    )

    val RxJava = arrayOf(
        "io.reactivex.rxjava3:rxkotlin:${Versions.RX.rxKotlin}",
        "io.reactivex.rxjava3:rxjava:${Versions.RX.rxJava}"
    )
    val RxAndroid = arrayOf(
        "io.reactivex.rxjava3:rxandroid:${Versions.RX.rxAndroid}"
    )

    val Retrofit = arrayOf(
        "com.squareup.okhttp3:okhttp:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Retrofit.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofit}"
    )


    const val JavaxInject = "javax.inject:javax.inject:${Versions.JavaxInject}"

    const val Hilt = "com.google.dagger:hilt-android:${Versions.HiltVersion}"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:${Versions.HiltVersion}"

    const val Gson = "com.google.code.gson:gson:${Versions.GSON}"

    const val Picasso = "com.squareup.picasso:picasso:${Versions.Picasso}"

    const val Ktlint = "com.pinterest:ktlint:${Versions.KTLINT}"

    const val ZoomableImage = "com.github.chrisbanes:PhotoView:${Versions.zoomableImageViewVersion}"

}