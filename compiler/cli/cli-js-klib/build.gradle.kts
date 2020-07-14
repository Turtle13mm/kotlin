plugins {
    kotlin("jvm")
    id("jps-compatible")
}

dependencies {
    compile(project(":compiler:cli"))
    compile(project(":compiler:ir.serialization.js"))
    compileOnly(project(":compiler:ir.tree.persisting"))
    runtimeOnly(project(":kotlin-reflect"))
    if (Platform[193].orLower()) {
        compile(intellijDep()) { includeJars("picocontainer", rootProject = rootProject) }
    }
    compile(intellijDep()) { includeJars("trove4j", "guava", "jdom", rootProject = rootProject) }
    compile(intellijCoreDep()) { includeJars("intellij-core") }
}

sourceSets {
    "main" { projectDefault() }
}
