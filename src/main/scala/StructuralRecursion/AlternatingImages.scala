import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

@main def Alternating(): Unit = {

    def circle(): Image = {
    // tidy up the indentation!
      Image.circle(15).
      strokeColor(Color.rosyBrown).
      strokeWidth(3).
        on(
          Image.circle(30).
          strokeColor(Color.royalBlue).
          strokeWidth(3))
    }

    def star(): Image = {
    // tidy up the indentation!
      Image.star(5,8,16).
      strokeColor(Color.green).
      strokeWidth(3).
        on(
          Image.star(5,16,32).
          strokeColor(Color.blue).
          strokeWidth(3))
    }

    def alternatingRow(count: Int): Image = {

        count match{

            case 0 => Image.empty
            //TODO: I know this works, but don't know how. I can only learn it as a pattern
            case n => 
                if (n % 2 == 0) star().beside(alternatingRow(n-1))
                else circle().beside(alternatingRow(n-1))
        }
    }

    alternatingRow(5).draw()
        

        


    
}

