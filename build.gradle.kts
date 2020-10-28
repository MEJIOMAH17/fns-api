plugins {
    id("maven-publish")
    java
}
repositories {
    jcenter()
}
group = "com.mejiomah17"
version = "0.1.0"
val githubToken: String by project

dependencies {
    implementation("org.apache.httpcomponents:httpclient:4.5.6")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("org.json:json:20180813")
    testImplementation("junit:junit:4+")
}

publishing{
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/MEJIOMAH17/fns-api")
            credentials {
                username = "MEJIOMAH17"
                password = githubToken
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}