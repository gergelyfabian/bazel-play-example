name := "play-example"

version := "0.0.1"

scalaVersion := "2.13.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayFilters)

val myDeps = Seq(
  guice,
  "org.slf4j"               %   "slf4j-api"                   % "1.7.26",
  "ch.qos.logback"          %   "logback-classic"             % "1.2.3",
  "org.webjars"             %   "bootstrap"                   % "3.4.1",
  "org.scalatest"           %%  "scalatest"                   % "3.0.8"         % "test"
)

libraryDependencies ++= {
  // Code to print out information that you can use to set up Bazel dependencies.
  println("Add the following lines to your maven_install definition:")
  myDeps.foreach { dep =>
    val (suffix, postfix) = dep.crossVersion match {
      case b: Binary =>
        ("_%s", " % scala_binary_version")
      case _ =>
        ("", "")
    }
    println(s""""${dep.organization}:${dep.name}${suffix}:${dep.revision}"${postfix},  ${dep.configurations.getOrElse("")}  ${if (dep.exclusions.nonEmpty) s"  ${dep.exclusions}" else ""}""")
  }

  println("")
  
  println("Add the following lines to the dependencies in your BUILD file:")
  myDeps.foreach { dep =>
    def cleanup(s: String) = s.replace(".", "_").replace("-", "_")
    val (suffix, postfix) = dep.crossVersion match {
      case b: Binary =>
        ("_%s", " % scala_binary_suffix")
      case _ =>
        ("", "")
    }
    println(s""""@maven//:${cleanup(dep.organization)}_${cleanup(dep.name)}${suffix}"${postfix},""")
  }
  
  myDeps
}
