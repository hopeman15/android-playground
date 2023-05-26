import io.gitlab.arturbosch.detekt.Detekt

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false

    id("io.gitlab.arturbosch.detekt") version "1.23.0"
    id("org.jmailen.kotlinter") version "3.14.0"
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "org.jmailen.kotlinter")

    detekt {
        buildUponDefaultConfig = false
        allRules = false
        config.setFrom(files("$rootDir/detekt/default-detekt-config.yml"))
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "17"
        reports {
            xml.required.set(false)
            html.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
        }
        exclude("**/resources/**")
        exclude("**/build/**")
    }
}
