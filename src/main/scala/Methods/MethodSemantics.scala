import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def MSemantics(): Unit = {

    

    // def square(x : Int) : Int = { // don't need braces
        
    //     x * x

    // }

    // {
    //     val x = 2
        
    //     println(square(x))
    // }

    //////// Exercise:  Method Order of Evaluation ////////

    def example(a: Int, b: Int) : Int = {
        println("In the body!")

        a + b 
    }

    // println(example(5, 2))

    // can do this because possible to pass a function to a function
    println(example({ println("a"); 1 }, { println("b"); 2 }))


}