import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def WritingM2(): Unit = {

    def circle(color: Color, diameter: Double): (Image, Double, Color) = {
      // start with a colour & size, draw it, update it for the next iter
      // return Image, new colour & new size
      val aCircle = Image.circle(diameter)
                    .strokeWidth(3)
                    .strokeColor(color)

      val newDiameter = diameter + 15
      val newColor = color.spin(15.degrees)

      (aCircle, newDiameter, newColor)

    }

    def gradientConcentricCircles(color: Color, diameter: Double): Image = {

      val (circle1, diameter1, colour1) = circle(color, diameter)
      val (circle2, diameter2, colour2) = circle(colour1, diameter1)
      val (circle3, diameter3, colour3) = circle(colour2, diameter2)
      val (circle4, diameter4, colour4) = circle(colour3, diameter3)
      val (circle5, diameter5, colour5) = circle(colour4, diameter4)
      val (circle6, diameter6, colour6) = circle(colour5, diameter5)

      circle6.on(circle5).on(circle4).on(circle3).on(circle2).on(circle1)

    }

    gradientConcentricCircles(Color.cornflowerBlue, 50).draw()

    // val (aCircle, aDiameter, aColour) = circle(Color.cornflowerBlue, 50)

    // val (newCircle, _, _) = circle(aColour,aDiameter)

    // newCircle
    // .on(aCircle).draw()

    


}