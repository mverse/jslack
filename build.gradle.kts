plugins {
  id("io.mverse.project")
  kotlin("jvm")
}

group = "io.mverse.slick"

mverse {
  dependencies {
    compile("kotlin-stdlib")
    testCompile("junit")
  }

  isDefaultDependencies = false
  coverageRequirement = 0.0
}

repositories {
  jcenter()
  maven("https://kotlin.bintray.com/kotlinx")
}

dependencyManagement {
  dependencies {
    val kotlin: String by project
    dependencySet("org.jetbrains.kotlin:$kotlin") {
      entry("kotlin-stdlib")
      entry("kotlin-runtime")
      entry("kotlin-stdlib-common")
      entry("kotlin-stdlib-jdk7")
      entry("kotlin-stdlib-jdk8")
      entry("kotlin-reflect")
      entry("kotlin-test-annotations-common")
      entry("kotlin-test")
      entry("kotlin-test-junit")
    }
  }
}

dependencies {
  compileOnly("com.squareup.okhttp3:okhttp:3.11.0")

  val ktor: String by project
  compileOnly("io.ktor:ktor-client-core:$ktor")
  compileOnly("io.ktor:ktor-client-cio:$ktor")
  compileOnly("io.ktor:ktor-client-json:$ktor")
  compileOnly("io.ktor:ktor-client-gson:$ktor")

  testCompile("io.ktor:ktor-client-core:$ktor")
  testCompile("io.ktor:ktor-client-cio:$ktor")
  testCompile("io.ktor:ktor-client-json:$ktor")
  testCompile("io.ktor:ktor-client-gson:$ktor")

  compile("org.slf4j:slf4j-api:1.7.25")
  compile("com.google.code.gson:gson:2.8.5")

  // None
  testCompile("com.willowtreeapps.assertk:assertk-jvm:0.11")
}
