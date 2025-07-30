package flowers

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._
import doodle.syntax.angle

@main def parametricCurve(): Unit = {

  def drawCurve(points: Int, marker: Image, curve: Angle => Point): Image = {

    val turn = Angle.one / points

    def loop(count: Int): Image = {
      count match {
        case 0 => 
          // marker.at(curve(Angle.zero))
          val point = curve(Angle.zero)
          marker.at(point)

        case n =>
          marker.at(curve(turn * (2 * count))).on(loop(n - 1))
      }
    }

    loop(points)
  }

  // A parametric curve is Angle => Point

  // This is a Angle => Point function. This is a parametric curve.
  val circle: Angle => Point = (angle: Angle) => Point.polar(100, angle)

  // This draws a parametric circle
  // drawCurve(128, Image.circle(5).fillColor(Color.darkOrange), circle).draw()

  ////////////////// Spiral //////////////////

  // WWKCD? 
  val parametricSpiral: Angle => Point = (angle: Angle) => Point.polar(100 * angle.toTurns, angle)

  // This draws a parametric spiral
  // drawCurve(64, Image.circle(5).fillColor(Color.darkOrange), parametricSpiral).draw()

  ////////////////// Expressive Drawing //////////////////

  def drawExpressiveCurve(points: Int, marker: (Point, Angle) => Image, curve: Angle => Point): Image = {

    val turn = Angle.one / points

    def loop(count: Int): Image = {
      count match {
        case 0 => 
          val point = curve(Angle.zero)
          marker(point, turn).at(point)

        case n =>
          val point = curve(turn * count)
          marker(point,turn).at(point).on(loop(n - 1))
      }
    }

    loop(points)
  }

  // modifying point.r changes the size of the marker
  // val marker: Point => Image = (point: Point) => Image.circle(point.r * 0.125).fillColor(Color.crimson.spin(point.angle))

  // TODO: now I need to figure out how to be able to pass it the '8' int
  val starMarker: (Point, Angle) => Image = (point: Point, turn: Angle) => Image.star((point.angle.toDegrees/(turn.toDegrees)).toInt + 2, 20, 10) // problem: i would need to t

  // drawExpressiveCurve(8, marker, parametricSpiral).draw()

  drawExpressiveCurve(8, starMarker, parametricSpiral).draw()


}
