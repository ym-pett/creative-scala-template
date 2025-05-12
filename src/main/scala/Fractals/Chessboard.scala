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
    val base = red.beside(black).above(black.beside(red))

    def loop(count: Int): Image = {
      count match {
        case 0 => base
        case n =>
          // TODO: discuss - both my versions don't call loop directly, whereas textbook does
          val square = chessboard(n - 1)
          square.beside(square).above(square.beside(square))
        //   chessboard(n - 1)
        //     .beside(chessboard(n - 1))
        //     .above(chessboard(n - 1).beside(chessboard(n - 1)))

      }
    }
    loop(count)
  }

  chessboard(2).draw()

}
