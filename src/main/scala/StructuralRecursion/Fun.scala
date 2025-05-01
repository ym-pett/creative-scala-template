import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Fun(): Unit = {

    def star(increment: Int): Image = {

        Image.star(7, 10 + (increment*5), 5 + (increment*5)).
        strokeColor(Color.orangeRed.spin((5*increment).degrees)).
        strokeWidth(5)
    }

    def funRow(count: Int): Image = {
        // TODO: talk over why this works, i.e. how does the n in star() get decreased?  
        count match {

            case 0 => Image.empty
            
            case n => star(n).beside(funRow((n-1)))

        }
            
        
    }

    funRow(5).draw()


}