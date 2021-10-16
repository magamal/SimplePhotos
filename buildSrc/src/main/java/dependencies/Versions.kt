package dependencies

/**
 * Created at Mahmoud Gamal on 3/13/19
 *
 * Version that will be used in Dependencies kotlin file.
 */

@Suppress("unused")
object Versions {

    object AndroidX {
        const val main = "1.1.0"
        const val material = "1.0.0"
        const val multiDex = "2.0.0"
        const val constraintLayout = "1.1.3"
        const val lifeCycle = "2.1.0"
        const val fragmentKTX = "1.3.6"
    }

    object Testing {
        const val mockito = "2.10.0"
        const val espresso = "3.1.2-alpha01"
        const val runner = "1.1.2-alpha01"
        const val junit = "4.12"
        const val junitPlatform = "1.0.0"
        const val androidXRunner = "1.1.1"
    }

    object Kotlin {
        const val std = "1.5.0"
    }

    const val KOIN = "2.2.3"

    object Google {

    }

    object RX {
        const val rxAndroid = "3.0.0"
        const val rxKotlin = "3.0.1"
        const val rxJava = "3.0.9"
    }

    object Retrofit {
        const val retrofit = "2.9.0"
        const val okHttp = "4.9.0"
    }

    const val Picasso = "2.71828"

    const val GSON = "2.8.0"

    const val KTLINT = "0.34.2"

    const val HiltVersion = "2.38.1"
    const val JavaxInject = "1"

    const val zoomableImageViewVersion = "2.3.0"

}