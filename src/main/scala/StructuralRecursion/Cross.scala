import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Cross(): Unit = {

    def cross(count: Int): Image = {

      val inside = Image.regularPolygon(6, 10)
                   .strokeColor(Color.red)
                   .strokeWidth(5)

      val petal = Image.circle(8)
                   .strokeColor(Color.turquoise)
                   .strokeWidth(5)
                                .on(
                        Image.circle(10)
                        .strokeColor(Color.cornflowerBlue)
                        .strokeWidth(10))

      

      count match {

        case 0 => inside
        // done: discuss this, as to me this should just print the original single cross n-times
        case n => petal.above(petal.beside(cross(n-1).beside(petal))).above(petal)
        }



    }

    cross(3).draw()




}