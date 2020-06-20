package dependencies

import Versions

/**
 * Created by Ahmed Abd-Elmeged on 4/18/20.
 */
object Dependencies {

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.Build.gradlePlugin}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlin}"
        const val gradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"
        const val allOpenPlugin = "org.jetbrains.kotlin:kotlin-allopen:${Versions.Kotlin.kotlin}"
        const val detektPlugin =
            "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.Kotlin.detekt}"
        const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.Kotlin.ktlint}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintlayout}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
        const val fragmentTesting =
            "androidx.fragment:fragment-testing:${Versions.AndroidX.fragment}"
        const val activity = "androidx.activity:activity:${Versions.AndroidX.activity}"
        const val ktx = "androidx.core:core-ktx:${Versions.AndroidX.ktx}"
        const val swiperefreshlayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.swiperefreshlayout}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerview}"

    }

    object Jetpack {
        const val lifecycle =
            "androidx.lifecycle:lifecycle-extensions:${Versions.Jetpack.lifecycle}"
        const val room = "androidx.room:room-runtime:${Versions.Jetpack.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.Jetpack.room}"
        const val roomRx = "androidx.room:room-rxjava2:${Versions.Jetpack.room}"
        const val navigationUi =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.navigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.navigation}"
        const val navigationSafeArgsPlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.navigation}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.Google.material}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.Libraries.retrofit}"
        const val rxjavaAdapter =
            "com.squareup.retrofit2:adapter-rxjava2:${Versions.Libraries.retrofit}"
        const val moshiAdapters =
            "com.squareup.moshi:moshi-adapters:${Versions.Libraries.moshi}"
        const val moshiCodegen =
            "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Libraries.moshi}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Libraries.okhttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okhttp}"
    }

    object Rx {
        const val java = "io.reactivex.rxjava2:rxjava:${Versions.Libraries.rxjava}"
        const val android = "io.reactivex.rxjava2:rxandroid:${Versions.Libraries.rxandroid}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.Libraries.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.Libraries.dagger}"
        const val assistedInject =
            "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.Libraries.assistedInject}"
        const val assistedInjectCompiler =
            "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.Libraries.assistedInject}"
    }

    object Util {
        const val timber = "com.jakewharton.timber:timber:${Versions.Libraries.timber}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Libraries.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Libraries.glide}"
    }

    object Lint {
        const val api = "com.android.tools.lint:lint-api:${Versions.Libraries.lint}"
        const val checks = "com.android.tools.lint:lint-checks:${Versions.Libraries.lint}"
        const val tests = "com.android.tools.lint:lint-tests:${Versions.Libraries.lint}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val core = "androidx.test:core:${Versions.Test.core}"
        const val arch = "android.arch.core:core-testing:${Versions.Jetpack.lifecycle}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Test.mockitokotlin}"
        const val robolectric = "org.robolectric:robolectric:${Versions.Test.robolectric}"
        const val jacoco = "org.jacoco:org.jacoco.core:${Versions.Test.jacoco}"
    }

    object AndroidTest {
        const val runner = "androidx.test:runner:${Versions.AndroidTest.runner}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTest.espresso}"
        const val rules = "androidx.test:rules:${Versions.AndroidTest.rules}"
        const val truth = "androidx.test.ext:truth:${Versions.AndroidTest.truth}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidTest.junit}"
        const val mockitoAndroid = "org.mockito:mockito-android:${Versions.AndroidTest.mockito}"
    }
}