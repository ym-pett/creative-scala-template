package flowers

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._

@main def functionsLit(): Unit = {

  val square = (x: Int) => x * x

  val rotateColour = (x: Color, y: Angle) => x.spin(y)

  val imageSequence = (z: Image) =>
    z.fillColor(Color.turquoise)
      .beside(
        z.fillColor(rotateColour(Color.turquoise, 15.degrees))
          .rotate(90.degrees)
      )
      .beside(
        z.fillColor(
          rotateColour(Color.turquoise, 30.degrees)
        ) rotate (180.degrees)
      )
      .beside(
        z.fillColor(
          rotateColour(Color.turquoise, 45.degrees)
        ) rotate (270.degrees)
      )

  println(square(3))

  imageSequence(Image.triangle(12, 24)).draw()

  // TODO: discuss exercise 2 with noel, confirm a function's type is both its input and output? 

}
