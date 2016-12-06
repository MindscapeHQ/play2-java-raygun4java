name := """play-java-2.3-rg4java"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.mindscapehq" % "raygun4java-play2" % "2.2.0"
)