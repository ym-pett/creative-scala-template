import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def WritingM(): Unit = {

    // box: take colour for box & angle, create box with the colour spun by angle

    def box(color: Color, angle: Int) : Image = {
        val new_colour = color.spin(angle.degrees)
        val box = 
            Image.rectangle(40,40).
                strokeWidth(5.0).
                strokeColor(color).
                fillColor(new_colour)
        // TODO: how to make it return new_colour so that it can be passed to the next??
    }

    // gradientBoxes: takes Colour, calls box & returns image of 5 boxes filled with color rotated by 15degree

    def gradientBoxes(color: Color) : Image = {

        box(color, 15.degrees) beside // here I'd need it to return the newcolour & pass it to next function call
        box(new_colour, 15.degrees) beside
        box(new_colour, 15.degrees) beside
        box(new_colour, 15.degrees) beside
    }


}