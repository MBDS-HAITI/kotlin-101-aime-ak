plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.9.0'
}

group = 'com.android.com.kotlin'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.jetbrains.kotlin:kotlin-stdlib'
}

kotlin {
    jvmToolchain(11)
}

tasks.register('runLesson2b', JavaExec) {
    mainClass = 'com.android.com.kotlin.one.Lesson2bKt'
    classpath = sourceSets.main.runtimeClasspath
}

