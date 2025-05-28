package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def polyP(): Unit = {

  def polygonPoints(sides: Int, radius: Int): Image = {

    val inc = 360 / sides

    val dot = Image.circle(5)

    def loop(count: Int): Image = {
      
      count match {
        case 0 => Image.empty
        case n => dot.on(loop(dot.at(Point(radius, (n * inc).degrees))))
      }
    }

    loop(count)
  }

  polygonPoints(3, 10)

}
