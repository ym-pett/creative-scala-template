import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import doodle.effect.Renderer

@main def ExpressiveExpressionsExercises(): Unit = {

    // Exercise: Compilation Target

    // Image.circle(20)
    // .on(Image.circle(40))
    // .on(Image.circle(60)).draw()

    // trying to write above as a for loop..
    // val circles = (1 to 3).map { i =>
    // val radius = i * 20
    // Image.circle(radius)
    // }

    // // here we're unpacking by applying 'on' from left to right
    // val combinedCircles = circles.reduceLeft((a, b) => a.on(b))

    // combinedCircles.draw()

    // Exercise: Compilation Target, adding the stand

    val circles = (1 to 3).map { i =>
        val radius = i * 20
        Image.circle(radius)
    }

    // here we're unpacking by applying 'on' from left to right
    val combinedCircles = circles.reduceLeft((a, b) => a.on(b))

    Image.rectangle(20,10)
    .below(
        Image.rectangle(10,20)
        .below(combinedCircles)
    ).draw()

    

    

}
