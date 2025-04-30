import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def LineB(): Unit = {

    val aBox = Image.square(20).fillColor(Color.royalBlue)

    // val oneBox = aBox
    // val twoBoxes = aBox.beside(oneBox)
    // val threeBoxes = aBox.beside(twoBoxes)

    // threeBoxes.draw()

    def boxes(count: Int): Image = {
      count match {
        case 0 => Image.empty
        case n => aBox.above(boxes(n-1))
      }
    }



    val sixb = boxes(4)

    sixb.draw()


}