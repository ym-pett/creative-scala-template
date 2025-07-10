package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import scala.annotation.tailrec

@main def polyP(): Unit = {

  // can move this outside as I only need to define once
  val dot = Image.circle(5)

  def polygonPoints(sides: Int, radius: Double): Image = {

    val inc = 360 / sides // 120
// stretch goal make it tail recursive :)
    def loop(count: Int): Image = {

      count match {
        case 0 => Image.empty
        case n => dot.at(Point(radius, (n *inc).degrees)).on(loop(n - 1))
      }
    }

    loop(sides)
  }

  def polygonPointsTailrecursive(sides: Int, radius: Double): Image = {

    val inc = 360 / sides // 120
    
    @tailrec
    def loop(count: Int, accumulatedImage: Image): Image = {

      count match {
        case 0 => accumulatedImage
        case n => loop(n -1, dot.at(Point(radius, (n *inc).degrees)).on(accumulatedImage))
      }
    }

    loop(sides, Image.empty)
  }



  polygonPointsTailrecursive(3, 50)
  .fillColor(Color.crimson)
  .beside(polygonPointsTailrecursive(5, 50).fillColor(Color.lawngreen))
  .beside(polygonPointsTailrecursive(7, 50).fillColor(Color.dodgerBlue)).draw()

}
