scalaVersion := "2.12.7"
name := "algos"
organization := "ingegnati.it"
// We will use Semver for this project
version := "0.0.1"

// libraries
lazy val scalaTestVersion = "3.0.1"
lazy val ammoniteVersion = "1.3.2"


libraryDependencies += "org.scalatest"       %% "scalatest"            % scalaTestVersion  % "test"
libraryDependencies += "com.lihaoyi" % "ammonite" % ammoniteVersion % "test" cross CrossVersion.full