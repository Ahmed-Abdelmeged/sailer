import org.gradle.api.JavaVersion

/**
 * Created by Ahmed Abd-Elmeged on 4/18/20.
 */
object Config {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = 29

    val javaVersion = JavaVersion.VERSION_1_8

    const val testInstrumentationRunner = "com.sailer.core.testing.runner.SailerTestRunner"
}