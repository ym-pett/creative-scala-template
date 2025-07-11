package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Boxes2(): Unit = {

  def gradientB2(count: Int): Image = {
// EXTENSION: re-code this to memorise?
    def loop(count: Int): Image = {
      val aBox = Image
        .square(20)
        .fillColor(Color.cornflowerBlue.spin((count * 30).degrees))

      count match {
        case 0 => Image.empty
        case n => aBox.beside(loop(n - 1))
      }
    }
    loop(count)
  }

  gradientB2(5).draw()
}
