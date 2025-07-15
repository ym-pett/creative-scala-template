package flowers

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._

@main def gradBoxesRev(): Unit = {

  //////////// Exercise: Gradient Boxes Revisited ////////////

  // Function; has =>
  val gradBoxes: (Int, Image) => Image =
    (count, image) =>
      Image
        .square(10)
        .fillColor(Color.seaGreen.spin(15.degrees * count))
        .beside(image)

  // Method: starts with def
  def fold(count: Int, f: (Int, Image) => Image): Image =
    count match {
      case 0 => Image.empty
      case n => f(n, fold(count - 1, f))
    }


  // fold(10, gradBoxes).draw()

  // function & method discussion:

  // def addOne(x: Int): Int = x + 1 // Scala method
  // x => x + 1 // Scala function
  // lambda x: x + 1 // Python "lambda"
  // Functions in Scala are "first class" but methods are not.
  // Methods in Python are "first class".
  // First class means:
  // 1. assigned to a variable
  // 2. passed as an argument to a method or function
  // 3. returned from a method or function

  ////////////////// Exercise: Decreasing Dots //////////////////

  val decreasingDots: (Int, Image) => Image =
    (count, image) =>
      Image
        .circle(10 * count)
        .fillColor(Color.orangeRed.spin(10.degrees * count))
        .beside(image)

  // fold(7, decreasingDots).draw()

  ////////////////// Once more to get the hang //////////////////

  val starTrail: (Int, Image) => Image =
    (count, image) =>
      Image
      .star(count +3 , 10 * count, 5 * count)
      .fillColor(Color.paleTurquoise.spin(15.degrees * count))
      .beside(image)

  fold(8, starTrail).draw()

}
