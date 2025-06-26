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
    // TODO: rewrite this solution so we don't decrement, but can build up from the smallest radius
    val dec = biggest_radius / count

    // TODO: discuss alternative base case I had:
      // count match {
        // case x if count < 3 =>
        //   Image.empty
        // case n => stackingPolygons...

    count match {
      case 0 =>
        Image.empty
      case n => stackingPolygons(n - 1, biggest_radius - dec).on(regularPolygon(n+2, biggest_radius)
      .strokeWidth(2)
      .strokeColor(Color.crimson.darkenBy((n*0.1).normalized)))
    }
  }

  stackingPolygons(8, 50).draw()

}
