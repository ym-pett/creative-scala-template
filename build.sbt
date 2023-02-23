scalaVersion := "2.13.10"

console / initialCommands := """
      |import doodle.core._
      |import doodle.image._
      |import doodle.image.syntax.all._
      |import doodle.image.syntax.core._
      |import doodle.java2d._
      |import cats.effect.unsafe.implicits.global
    """.trim.stripMargin

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle" % "0.15.0"
)
