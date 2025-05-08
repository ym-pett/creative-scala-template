package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def SierpinskiTriangle(): Unit = {
  def sierpinski(count: Int): Image =
    count match {
      case 0 => Image.equilateralTriangle(30).strokeColor(Color.hotpink)
      case n =>
        val triangle = sierpinski(n - 1)
        triangle.beside(triangle).below(triangle)
    }

  sierpinski(3).draw()
}
