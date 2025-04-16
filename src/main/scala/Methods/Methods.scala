import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Method(): Unit = {

    // val paleGoldenrod = {
    // val box =
    //     Image.rectangle(40, 40).
    //     strokeWidth(5.0).
    //     strokeColor(Color.paleGoldenrod.spin(30.degrees)).
    //     fillColor(Color.paleGoldenrod)

    // box.beside(box).beside(box).beside(box).beside(box).draw()
    // }

    // val lightSteelBlue = {
    // val box =
    //     Image.rectangle(40, 40).
    //     strokeWidth(5.0).
    //     strokeColor(Color.lightSteelBlue.spin(30.degrees)).
    //     fillColor(Color.lightSteelBlue)

    // box.beside(box).beside(box).beside(box).beside(box).draw()
    // }

    // val mistyRose = {
    // val box =
    //     Image.rectangle(40, 40).
    //     strokeWidth(5.0).
    //     strokeColor(Color.mistyRose.spin(30.degrees)).
    //     fillColor(Color.mistyRose)

    // box.beside(box).beside(box).beside(box).beside(box).draw()
    // }

    /////// colour method abstracted /////////

    def boxes(color: Color): Image = {
    val box =
        Image.rectangle(40, 40).
        strokeWidth(5.0).
        strokeColor(color.spin(30.degrees)).
        fillColor(color)

    box.beside(box).beside(box).beside(box).beside(box)
    }

    // Create boxes with different colors
    boxes(Color.paleGoldenrod).draw()
    boxes(Color.lightSteelBlue).draw()
    boxes(Color.mistyRose).draw()


}