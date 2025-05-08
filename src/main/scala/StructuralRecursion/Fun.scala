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
        // done: talk over why this works, i.e. how does the n in star() get decreased?  
        count match {
            case 0 => Image.empty
            case n => star(n).beside(funRow((n-1)))
        }
    }

    funRow(5).draw()

    // funRow(2)
    // subst count == 2 into
    // count match {
    //   case 0 => Image.empty
    //   case n => star(n).beside(funRow((n-1)))
    // }

    // 2 match {
    //   case 0 => Image.empty
    //   case n => star(n).beside(funRow((n-1)))
    // }

    // 2 match {
    //   matches with n == 2
    //   case n => star(n).beside(funRow((n-1)))
    // }

    //   matches with n == 2
    //   case n => star(n).beside(funRow((n-1)))

    // star(2).beside(funRow(2 - 1))
    // star(2).beside(funRow(1))
 
    // star(2).beside(
      // subst count == 1 into
      // count match {
      //   case 0 => Image.empty
      //   case n => star(n).beside(funRow((n-1)))
      // }
    // )

    // star(2).beside(
      // 1 match {
      //   subst n == 1
      //   case n => star(n).beside(funRow((n-1)))
      // }
    // )

    // star(2).beside(
      //   star(1).beside(funRow((1-1)))
    // )

    // star(2).beside(
      //   star(1).beside(funRow((0)))
    // )

    // star(2).beside(
      //   star(1).beside(
      //      funRow((0))
      //   )
    // )

    // star(2).beside(
      //   star(1).beside(
      //      Image.empty
      //   )
    // )

    // star(2).beside(star(1).beside(Image.empty))
}