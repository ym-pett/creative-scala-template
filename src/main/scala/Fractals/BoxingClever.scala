package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Boxing(): Unit = {

  def boxes(count: Int): Image = {

    val aBox = Image.square(20).fillColor(Color.royalBlue)

    def loop(count: Int): Image = {

      count match {
        case 0 => Image.empty
        case n => aBox.beside(loop(n - 1))
      }
    }
    // don't forget to call loop!
    loop(count)
  }

  boxes(2).draw()
}

