import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def WritingMethodsForloop(): Unit = {

    def circle(color: Color, n: Int): Image = 
      Image.circle(50 + (n * 10)).
      strokeColor(color.spin((15 * n).degrees)).
      strokeWidth(3)

    // EXTENSION: when I know more ways of looping, rewrite with different operations? 
    def concentricCircles(color: Color): Image = {
      val circles = (0 to 4).map { n =>
      circle(color, n)
      }
      circles.reduceLeft((a, b) => a.on(b))
    }


    concentricCircles(Color.cadetBlue).draw()


}