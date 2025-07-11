package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def concentricPolyV2(): Unit = {

  def regularPolygon(sides: Int, radius: Double): Image = {

    val inc = 360 / sides

    def loop(count: Int): ClosedPath = {

      count match {
        case 0 => ClosedPath.empty.moveTo(radius, 0.degrees)
        case n => loop(n - 1).lineTo(radius, (n * inc).degrees)
      }
    }
    Image.path(loop(sides))
  }

  def stackingPolygons(count: Int, radius: Double): Image = {
    // modification can happen on regularpoygon or stackingpolygons
    // see other concentricpoly...
    count match {
      case 0 =>
        Image.empty
      case n =>
        regularPolygon(n + 2, radius * (n * 0.1))
          .strokeWidth(2)
          .strokeColor(Color.crimson.darkenBy((n * 0.1).normalized))
          .on(stackingPolygons(n - 1, radius))
    }
  }

  stackingPolygons(8, 50).draw()
}
