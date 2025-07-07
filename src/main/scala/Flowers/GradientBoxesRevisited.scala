package flowers

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._


@main def gradBoxesRev(): Unit = {

  val gradBoxes: (Int, Image) => Image =
    (count, image) =>
      Image
      .square(10)
      .fillColor(Color.seaGreen.spin(15.degrees * count))
      .beside(image)

  def fold(count: Int, gradBoxes: (Int, Image) => Image): Image =
    count match {
      case 0 => Image.empty
      case n => gradBoxes(n, fold(count -1, gradBoxes))
    }

  fold(5, gradBoxes).draw()
      
    


}