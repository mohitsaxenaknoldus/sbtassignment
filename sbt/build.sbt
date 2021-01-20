name := "hello"
version := "1.0"
scalaVersion := "2.12.12"

lazy val actor = project.in(file("actor"))
  .settings(
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.10",
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.10",
libraryDependencies += "org.scalactic" %% "scalactic" % "3.3.0-SNAP3",
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.10" % Test,
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-testkit" % "2.6.10" % Test
)

lazy val persistence = project.in(file("persistence"))
  .settings(
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3",
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.22",
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
libraryDependencies += "com.h2database" % "h2" % "1.4.200" % Test
)

lazy val root = project.in(file("root")).dependsOn(actor, persistence)

lazy val app = project.in(file(".")).dependsOn(root)

