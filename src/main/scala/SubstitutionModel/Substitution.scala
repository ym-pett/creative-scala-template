import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Substitution(): Unit = {
// 1 + ("Moonage daydream".indexOf("N")) // TODO how can I get the output for this? 

// 1 + ("Moonage daydream".indexOf(|"N"|))  // TODO doesn't run in a script, how can I run in worksheet or terminal? 

val name = "Ada"
println(name ++ " " ++ "Lovelace")

}