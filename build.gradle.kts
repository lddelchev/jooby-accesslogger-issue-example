plugins {
    val kotlinVersion = "1.7.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    application
}

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // Application server
    val joobyVersion = "2.16.1"
    implementation("io.jooby:jooby:$joobyVersion")
    implementation("io.jooby:jooby-jetty:$joobyVersion")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("org.apache.logging.log4j:log4j-to-slf4j:2.19.0")
    implementation("org.slf4j:jcl-over-slf4j:2.0.3")
}

application {
    mainClass.set("com.example.MainKt")
}
