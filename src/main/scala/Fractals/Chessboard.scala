package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def ChessboardRewritten(): Unit = {

  def chessboard(count: Int): Image = {

    val red = Image.square(20).fillColor(Color.red)
    val black = Image.square(20).fillColor(Color.black)
    val base = {
      println("created base")
      red.beside(black).above(black.beside(red))
    }

    def loop(count: Int): Image = {
      count match {
        case 0 => base
        case n =>
          // note you need to call loop, if you run via chessboard(n-1) base gets created each time!!
          val square = loop(n - 1)
          square.beside(square).above(square.beside(square))
        // definitely dislike syntax below, 1st much clearer
          // loop(n - 1)
          //   .beside(loop(n - 1))
          //   .above(loop(n - 1).beside(loop(n - 1)))

      }
    }
    loop(count)
  }

  chessboard(2).draw()

}
