import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Names(): Unit = {

    // why did i have to use def here? why not val? I take it it's an object, but why did it have to be? 
    // why no return statement? 
    // didn't work without `: Image = {`, is that like type setting? cause we have to be explicit about type? 
    def rectangle(width: Int, height: Int): Image = {
        Image.rectangle(width, height)

    }

    val horizontal_rectangle = rectangle(20,10)
    val vertical_rectangle = rectangle(10,20)

    val circles = (1 to 3).map { i =>
        val radius = i * 20
        Image.circle(radius)
    }

    // here we're unpacking by applying 'on' from left to right
    val combinedCircles = circles.reduceLeft((a, b) => a.on(b))

    // perpl. suggested extra brackets around this expression, why? runs with & without
    horizontal_rectangle
    .below(vertical_rectangle
        .below(combinedCircles)).draw()

}



