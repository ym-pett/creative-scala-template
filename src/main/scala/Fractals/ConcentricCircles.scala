package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Concentric(): Unit = {
  val circle = Image.circle(10).strokeColor(Color.skyBlue)

  def concentricCircle(count: Int): Image = {
    count match {
      case 0 => Image.empty
      case n => Image.circle(n * 10).on(concentricCircle(n - 1))
    }
  }

  // concentricCircle(7).draw()

  def fadingCircles(count: Int): Image = {
    count match {
      case 0 => Image.empty
      case n =>
        Image
          .circle(n * 10)
          .strokeColor(Color.seaGreen.fadeOutBy((n * 0.1).normalized))
          .strokeWidth(5)
          .on(fadingCircles(n - 1))
    }
  }

//   fadingCircles(10).draw()

  def colourChanger(count: Int): Image = {
    count match {
      case 0 => Image.empty
      case n =>
        Image
          .circle(n * 10)
          .strokeColor(Color.darkGoldenrod.spin((n * 8).degrees))
          .strokeWidth(5.0)
          .on(colourChanger(n - 1))
    }
  }
//   colourChanger(10).draw()
  def opArt(count: Int): Image = {
    count match {
      case 0 => Image.empty
      case n =>
        Image
          .square(10 * n)
          .fillColor(if n % 2 == 0 then Color.black else Color.white)
          .rotate((n * 5).degrees)
          .under(opArt(n - 1))
    }
  }

  opArt(100).draw()
}
