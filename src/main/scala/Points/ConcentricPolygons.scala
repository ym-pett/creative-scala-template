package points

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def concentricP(): Unit = {
// I could have imported this function from Paths.scala if it was written outside the
// @main
  def regularPolygon(sides: Int, radius: Double): Image = {

    val inc = 360 / sides

    def loop(count: Int): ClosedPath = {

      count match {
        case 0 => ClosedPath.empty.moveTo(radius, 0.degrees)
        case n => loop(n - 1).lineTo(radius, (n * inc).degrees)
      }
    }
    Image.path(loop(sides))
  }

  def stackingPolygons(count: Int, biggest_radius: Double): Image = {

    // figure out what the decrement should be
    val dec = biggest_radius / count

    // alternative base case I had & why it's better not to use:
      // count match {
        // case x if count < 3 =>
        //   Image.empty
        // case n => stackingPolygons...

    // Can 3 be the base case?
    // The natural numbers are 0, 1, 2, ...
    // We can transform them by adding 3 to get 3, 4, 5, ...
    // That's fine. There are still the same number of numbers.

    // Practical aspects: we want the compiler to catch errors. 
    // Scala doesn't have an untyped integer type, so we are using Int
    // as a substitute. This means the compiler won't prevent negative 
    // numbers. However it's easier for the user to remember to a non-negative
    // number than it is to remember to use 3 or greater.

    // Why not write
    // if n == 0 then ...
    // else ...
    //
    // 1. Get used to using pattern matching. Language constructs.
    // 2. I feel pattern matching more closely matches the definition of the natural numbers
    //    A natural number m is
    //    - 0; or
    //    - n
    //
    //    case 0 => ...
    //    case n => ...
    //
    //    if n == 0 then ...
    //    else ...
    // 
    //    is similar, but not quite as close to the definition
    // 3. We'll use this idea of structural recursion later
    //    (in unwritten parts of Creative Scala), where pattern matching
    //    is more powerful.
    count match {
      case 0 =>
        Image.empty
      case n => stackingPolygons(n - 1, biggest_radius - dec).on(regularPolygon(n+2, biggest_radius)
      .strokeWidth(2)
      .strokeColor(Color.crimson.darkenBy((n*0.1).normalized)))
    }
  }

  stackingPolygons(8, 50).draw()

}
