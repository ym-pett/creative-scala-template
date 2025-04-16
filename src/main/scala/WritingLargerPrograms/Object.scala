import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

// Try running ~compile and making a change to your code. TODO: discuss this as I didn't get it

object Circles {
  val circle = Image.circle(100)
  
  @main def go() = {
    circle.draw()
    }
}