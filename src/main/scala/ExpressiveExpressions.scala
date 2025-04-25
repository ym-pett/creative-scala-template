import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import doodle.effect.Renderer

@main def ExpressiveExpressions(): Unit = {
    // (Image.triangle(120, 80).draw()):Unit

    // Exercise: The Width of a Circle
    // Image.circle(50)
    // .beside(Image.circle(50))
    // .beside(Image.circle(50))
    // .on(Image.circle(150)).draw()

    ///////

    // Exercise: Evil Eye
    // Image
    // .circle(20).fillColor(Color.black)
    // .on(Image.circle(40).fillColor(Color.cornflowerBlue))
    // .on(Image.circle(60).fillColor(Color.white))
    // .on(Image.circle(100).fillColor(Color.midnightBlue)).draw()

    ///////

    // Exercise: Analogous Triangles

    // Image
    // .triangle(40,40)
    // .fillColor(Color.turquoise)
    // .beside(
    //     Image
    //     .triangle(40,40)
    //     .fillColor(Color.turquoise.spin(20.degrees)))
    // .below(
    //     Image
    //     .triangle(40,40)
    //     .fillColor(Color.turquoise.spin(40.degrees))).draw()

    // Exercise: Analogous Triangles with a for-loop DONE: discuss this? 

    val triangles = (0 to 2).map { i =>
        val angle = i * 20
        Image
        .triangle(40, 40)
        .fillColor(Color.turquoise.spin(angle.degrees))
    }

    val combined = triangles.head.beside(triangles(1)).below(triangles(2))

    combined.draw()








}
