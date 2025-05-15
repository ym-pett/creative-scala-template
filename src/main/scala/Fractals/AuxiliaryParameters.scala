package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Growing(): Unit = {

  def growingBoxes(count: Int, size: Int): Image =
    count match {
      case 0 => Image.empty
      case n =>
        Image
          .square(size).fillColor(Color.red)
          .beside(growingBoxes(n - 1, size + 10))
    }

    growingBoxes(3, 5)

}
