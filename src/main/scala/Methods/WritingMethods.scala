import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def WritingM(): Unit = {

    // box: take colour for box & angle, create box with the colour spun by angle

    def box(color: Color, angle: Int) : (Image, Color) = {
      val newColour = color.spin(angle.degrees)
      val imageBox = 
        Image.rectangle(40,40)
          .strokeWidth(5.0)
          .strokeColor(color)
          .fillColor(newColour)
        // TODO: is this the most convenient way to return?
      (imageBox, newColour)
    }
        
    // gradientBoxes: takes Colour, calls box & returns image of 5 boxes filled with colors rotated by 15degree

    def gradientBoxes(color: Color) : Image = {
      val (box1, color1) = box(color, 15)
      val (box2, color2) = box(color1, 15)
      val (box3, color3) = box(color2, 15)
      val (box4, color4) = box(color3, 15)
      val (box5, _)      = box(color4, 15)

      box1.beside(box2).beside(box3).beside(box4).beside(box5)
    }

    gradientBoxes(Color.cornflowerBlue).draw()

    // val (newbox, newcol) = box(Color.cornSilk, 15)

    // newbox.draw()

    // println(newcol)

    // temp


}