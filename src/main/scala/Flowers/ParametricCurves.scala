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
        case 0 => marker.at(curve(Angle.zero))
        case n =>
          marker.at(curve(turn * count)).on(loop(n - 1))
      }
    }

    loop(points)
  }

// TODO: discuss this is a function, right? drawCurve too? getting confused because of 'def'.. 
  val curve = (angle: Angle) => Point.polar(100, angle)

  drawCurve(8, Image.circle(5).fillColor(Color.darkOrange), curve)

}
