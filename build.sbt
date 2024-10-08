val AkkaVersion = "2.9.5"
val AkkaHttpVersion = "10.6.3"
val AkkaDiagnostics = "2.1.1"
val LogbackVersion = "1.5.6"
val ScalaVersion = "3.3.4"

ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.3.4"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

lazy val commonScalacOptions =
  Seq("-deprecation", "-feature", "-unchecked", "-Xlint", "-Ywarn-unused:imports", "-encoding", "UTF-8")

lazy val commonJavacOptions = Seq("-Xlint:unchecked", "-Xlint:deprecation")

lazy val commonSettings = Seq(
  organization := "com.mu.stream",
  scalaVersion := ScalaVersion,
  Compile / scalacOptions ++= commonScalacOptions,
  Compile / javacOptions ++= commonJavacOptions,
  run / javaOptions ++= Seq("-Xms128m", "-Xmx1024m"),
  run / fork := true,
  licenses := Seq(("APACHE-2.0", url("http://www.apache.org/licenses"))))

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "cdc_standalone_listener",
    idePackagePrefix := Some("org.mu.stream"),
    resolvers += "Akka library repository".at("https://repo.akka.io/maven"),
    Compile / run / mainClass := Some("org.mu.stream.Bootstrap"),
    Compile / packageBin / mainClass := Some("org.mu.stream.Bootstrap"),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
      "com.typesafe.akka" %% "akka-distributed-data" % AkkaVersion,
      "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
      "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "org.slf4j" % "slf4j-api" % "2.0.12",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
    )
  )