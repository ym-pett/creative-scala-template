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

    val curve:(angle: Angle) => Point =
      Point(100, angle)

    def loop(count: Int): Image = {
      count match {
        case 0 => marker.at(curve(Angle.zero))
        case n =>
          marker.at(curve(turn * count)).on(loop(n - 1))
      }
    }

    loop(points)
  }

  drawCurve(8, Image.circle(5).fillColor(Color.darkOrange))

}
