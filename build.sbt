name := "play-example"

version := "0.0.1"

scalaVersion := "2.13.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayFilters)

libraryDependencies ++= Seq(
  guice,
  "org.slf4j"               %   "slf4j-api"                   % "1.7.26",
  "ch.qos.logback"          %   "logback-classic"             % "1.2.3",
  "org.webjars"             %   "bootstrap"                   % "3.4.1",
  "org.scalatest"           %%  "scalatest"                   % "3.0.8"         % "test"
)
