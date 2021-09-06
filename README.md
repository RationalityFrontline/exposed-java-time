# exposed-java-time
[![Maven Central](https://img.shields.io/maven-central/v/org.rationalityfrontline.workaround/exposed-java-time.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.rationalityfrontline.workaround%22%20AND%20a:%22exposed-java-time%22)  [![Apache License 2.0](https://img.shields.io/github/license/rationalityfrontline/exposed-java-time)](https://github.com/RationalityFrontline/exposed-java-time/blob/master/LICENSE)

This library is a temporary workaround for the issue ["exposed-java-time.jar unusable with java module system"](https://github.com/JetBrains/Exposed/issues/853). 
It solves the problem mentioned in the issue by renaming package name from "org.jetbrains.exposed.sql.java-time" to "org.jetbrains.exposed.sql.javatime".

## Usage

First replace your dependency of "exposed-java-time" with this library, then alter your package import sentence (remove the hyphen).

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.rationalityfrontline.workaround:exposed-java-time:0.34.1")
}
```

## Reference

https://github.com/JetBrains/Exposed/issues/853

## License

exposed-java-time is released under the [Apache 2.0 license](https://github.com/RationalityFrontline/exposed-java-time/blob/master/LICENSE).

```
Copyright 2020-2021 RationalityFrontline

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```