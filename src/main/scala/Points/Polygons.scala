package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def polyP(): Unit = {

  def polygonPoints(sides: Int, radius: Double): Image = {

    val inc = 360 / sides

    val dot = Image.circle(5)

    def loop(count: Int): Image = {
      // TODO: discuss why this doesn't work, I'd like to do n += inc on each loop  
      count match {
        case 0 => Image.empty
        case n => dot.at(Point(radius, n +inc)).on(loop(n - 1))
      }
    }

    loop(sides)
  }

  polygonPoints(3, 50)
  .fillColor(Color.crimson)
  .beside(polygonPoints(5, 50).fillColor(Color.lawngreen))
  .beside(polygonPoints(7, 50).fillColor(Color.dodgerBlue)).draw()

}
