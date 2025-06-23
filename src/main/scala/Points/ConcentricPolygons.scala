package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def concentricP(): Unit = {
// TODO: could i have imported this function from Paths.scala?
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

  def stackingPolygons(count: Int, biggest_radius: Double): Image = {

    // figure out what the decrement should be
    val dec = biggest_radius / count

    count match {
      case 0 =>
        Image.empty // or should this be when sides = 3? but then we'd be going out, n +1, rather than in, n-1!
      case n => stackingPolygons(n - 1, biggest_radius - dec).on(regularPolygon(n, biggest_radius))
      // case n => regularPolygon(loop(n-1), first_radius * 1.5).on(regularPolygon(n, first_radius)
    }
  }

  stackingPolygons(6, 50).draw()

}
