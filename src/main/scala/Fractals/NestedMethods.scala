package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Nested(): Unit = {

  def cross(count: Int): Image = {
    val unit = {
      println("Creating unit")
      Image.circle(20)
    }
    count match {
      case 0 => unit
      case n => unit.beside(unit.above(cross(n - 1)).above(unit)).beside(unit)
    }
  }

  def cross_loopsyntax(count: Int): Image = {
    // new syntax where we're only creating unit once!
    val unit = {
      println("Creating unit using isolated loop function")
      Image.circle(20)
    }
    def loop(count: Int): Image = {
      count match {
        case 0 => unit
        case n => unit.beside(unit.above(loop(n - 1).above(unit))).beside(unit)
      }
    }

    loop(count)
  }

//   cross(3).draw()
  cross_loopsyntax(3).draw()

}
