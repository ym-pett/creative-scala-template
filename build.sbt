scalaVersion := "2.13.7"

// resolvers += Resolver.bintrayRepo("underscoreio", "training")

console / initialCommands := """
      |import doodle.core._
      |import doodle.image._
      |import doodle.image.syntax._
      |import doodle.image.syntax.core._
      |import doodle.java2d._
    """.trim.stripMargin

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle" % "0.10.1",
)
