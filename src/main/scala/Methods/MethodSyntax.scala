import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def MSyntax(): Unit = {

    //////// Exercise: Square ////////

    // def square(x : Int) : Int = { // don't need braces
        
    //     // x * x
    //     ???
    // }

    // println(square(4))

    //////// Exercise: Halve ////////

    def halve(x : Float) : Float =
        // TODO: does division by 2.0 offer additional security?
        x / 2

    println(halve(3))




}