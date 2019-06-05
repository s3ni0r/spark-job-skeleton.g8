import sbt._

name := """$name$"""

version := "0.1"

scalaVersion := "2.11.8"

scalafmtOnCompile in ThisBuild := true

scalacOptions in ThisBuild ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-feature",
  "-language:postfixOps"
)

lazy val sparkApps = project
  .in(file("."))
  .settings(Commons.dependencies)
  .settings(Commons.customAssembly)
  .settings(Commons.customDocker)
  .enablePlugins(
    JavaAppPackaging,
    sbtdocker.DockerPlugin,
    DockerComposePlugin
  )
