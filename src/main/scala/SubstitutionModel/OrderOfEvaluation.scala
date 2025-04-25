import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Order(): Unit = {
    
    Color.hsl({ println("a"); 0.degrees }, 
          { println("b"); 1.0 },
          { println("c"); 1.0 })

}