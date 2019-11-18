name := "cats-sandbox"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.1"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",   // source files are in UTF-8
  "-deprecation",         // warn about use of deprecated APIs
  "-unchecked",           // warn about unchecked type parameters
  "-feature",             // warn about misused language features
  "-language:higherKinds",// allow higher kinded types without `import scala.language.higherKinds`
  "-Xlint",               // enable handy linter warnings
//  "-Xfatal-warnings",     // turn compiler warnings into errors
)

libraryDependencies += "org.typelevel" %% "cats-effect" % "2.0.0"

val circeVersion = "0.12.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

lazy val doobieVersion = "0.8.2"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core"     % doobieVersion,
  "org.tpolecat" %% "doobie-postgres" % doobieVersion,
  "org.tpolecat" %% "doobie-specs2"   % doobieVersion % Test
)

configs(IntegrationTest extend(Test))

Defaults.itSettings



libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test,it"
libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.19" % "test,it"


testFrameworks += new TestFramework(
    "org.scalameter.ScalaMeterFramework")
  
  logBuffered := false

//addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.8")
