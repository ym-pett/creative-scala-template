package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def BoxesAlt(): Unit = {
// alternative to gradientBoxes with loop
  def gradientBl(count: Int, spn: Int): Image = {

    count match {
      case 0 => Image.empty
      case n =>
        Image
          .square(20)
          .fillColor(Color.cornflowerBlue.spin((spn).degrees))
          .beside(gradientBl(n - 1, spn + 30))

    }

  }

  gradientBl(3,10).draw()


}