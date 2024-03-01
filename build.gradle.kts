import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("war")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass = "com.solncev.Main"
}

group = "com.solncev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webmvc:${properties["springVersion"]}")
    implementation("org.springframework:spring-jdbc:${properties["springVersion"]}")
    implementation("org.springframework:spring-orm:${properties["springVersion"]}")
    implementation("org.springframework:spring-context-support:${properties["springVersion"]}")
    implementation ("org.springframework.data:spring-data-jpa:2.7.18")
    implementation("org.hibernate:hibernate-core:${properties["hibernateVersion"]}")
    implementation("org.hibernate:hibernate-entitymanager:${properties["hibernateVersion"]}")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:${properties["tomcatVersion"]}")
    implementation("com.mchange:c3p0:0.9.5.2")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("org.freemarker:freemarker:2.3.32")
    implementation("commons-fileupload:commons-fileupload:1.5")
}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
}
