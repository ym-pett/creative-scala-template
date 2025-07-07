package flowers

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._

@main def feelingFract(): Unit = {

  val sierpinski: (Int, Image) => Image =
    (count, image) => image.above(image.beside(image))

  val basicUnit = Image.equilateralTriangle(10).strokeColor(Color.hotpink)

  def fold(count: Int, base: Image, sierpinski: (Int, Image) => Image): Image =
    count match {
      case 0 => base
      case n => sierpinski(n, fold(count - 1, base, sierpinski))
    }

  fold(5, basicUnit, sierpinski).draw()

}
