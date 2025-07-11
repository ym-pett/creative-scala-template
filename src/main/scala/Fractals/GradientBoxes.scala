package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Boxes(): Unit = {

  def gradientBoxes(count: Int): Image = {
    count match {
      case 0 => Image.empty
      case n =>
        Image
          .square(20)
          .fillColor(Color.cornflowerBlue.spin((n * 30).degrees))
          .beside(gradientBoxes(n - 1))

    }

  }

  gradientBoxes(5).draw()


}
