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
          .square(size)
          .beside(growingBoxes(n - 1, size + 10))
    }
  // TODO: discuss indentation here, I had it wrongly indented by 1 & couldn't call .draw() on it, but could run
  growingBoxes(3, 10).draw()


}
