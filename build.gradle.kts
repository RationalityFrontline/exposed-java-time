import com.jfrog.bintray.gradle.BintrayExtension.PackageConfig
import com.jfrog.bintray.gradle.BintrayExtension.VersionConfig
import java.util.*

plugins {
    kotlin("jvm") version "1.4.10"
    `java-library`
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.5"
}

group = "org.rationalityfrontline.exposed"
version = "0.28.1"

val NAME = project.name
val DESC = "Removed hyphen from package name (\"java-time\" -> \"javatime\")"
val GITHUB_REPO = "RationalityFrontline/exposed-java-time"

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.exposed:exposed-core:$version")
}

tasks {
    register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenPublish") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            pom {
                name.set(NAME)
                description.set("$NAME ${project.version} - $DESC")
                url.set("https://github.com/$GITHUB_REPO")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        name.set("RationalityFrontline")
                        email.set("rationalityfrontline@gmail.com")
                    }
                }
                scm {
                    url.set("https://github.com/$GITHUB_REPO")
                }
            }
        }
    }
}

bintray {
    fun env(propertyName: String): String {
        return if (project.hasProperty(propertyName)) {
            project.property(propertyName) as String
        } else "Unknown"
    }

    user = env("BINTRAY_USER")
    key = env("BINTRAY_KEY")
    publish = true
    override = true
    setPublications("mavenPublish")
    pkg(closureOf<PackageConfig>{
        repo = "exposed"
        name = NAME
        desc = DESC
        setLabels("kotlin", "exposed", "exposed-java-time", "jpms")
        setLicenses("Apache-2.0")
        publicDownloadNumbers = true
        githubRepo = GITHUB_REPO
        vcsUrl = "https://github.com/$githubRepo"
        websiteUrl = vcsUrl
        issueTrackerUrl = "$vcsUrl/issues"
        version(closureOf<VersionConfig> {
            name = "${project.version}"
            desc = DESC
            released = "${Date()}"
            vcsTag = name
        })
    })
}