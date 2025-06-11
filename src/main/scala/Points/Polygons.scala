package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import scala.annotation.tailrec

@main def polyP(): Unit = {

  // can move this outside as I only need to define once
  val dot = Image.circle(5)

  def polygonPoints(sides: Int, radius: Double): Image = {

    val inc = 360 / sides // 120
// TODO: stretch goal make it tail recursive :)
    def loop(count: Int): Image = {

      count match {
        case 0 => Image.empty
        case n => dot.at(Point(radius, (n *inc).degrees)).on(loop(n - 1))
      }
    }

    loop(sides)
  }

  polygonPoints(3, 50)
  .fillColor(Color.crimson)
  .beside(polygonPoints(5, 50).fillColor(Color.lawngreen))
  .beside(polygonPoints(7, 50).fillColor(Color.dodgerBlue)).draw()

}
