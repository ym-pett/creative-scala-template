package fractals

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def liveSession(): Unit = {
  // WWKCD? What would keyboard cat do?
  val red = Image.square(20).fillColor(Color.red)
  val black = Image.square(20).fillColor(Color.black)
  val base = red.beside(black).above(black.beside(red))

//   base.draw()
  def chessboard(count: Int): Image =
    count match {
      case 0 => base
      case n => 
        // val square = chessboard(n - 1)
        // square.beside(square).above(square.beside(square))
        chessboard(n-1).beside(chessboard(n-1)).above(chessboard(n-1).beside(chessboard(n-1)))
    }

//    chessboard(0).draw() 
//    chessboard(1).draw() 
   chessboard(2).draw() 
}
