package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import scala.annotation.tailrec

@main def paths(): Unit = {

  def regularPolygon(sides: Int, radius: Double): Image = {

    val inc = 360 / sides

    def loop(count: Int): ClosedPath = {

      count match {
        case 0 => ClosedPath.empty.moveTo(radius, 0.degrees)
        case n => loop(n-1).lineTo(radius, (n*inc).degrees)
      }
    }
    Image.path(loop(sides))
  }

  def star(points: Int, outerRadius: Double, innerRadius: Double): Image = {
    val inc = 360 / points

    def loop(count: Int): ClosedPath = {
      count match {
        case 0 => ClosedPath.empty.moveTo(outerRadius, 0.degrees)
        case n => loop(n-1)
          .lineTo(innerRadius, ((n * inc - (inc / 2))).degrees)
          .lineTo(outerRadius, (n * inc).degrees)
      }
    }

    Image.path(loop(points))
  }

  // regularPolygon(6, 100).draw()
  // Image.star(5, 200, 100).draw()
  (Image.star(5, 200, 100).beside(star(5, 200, 100))).draw()
}