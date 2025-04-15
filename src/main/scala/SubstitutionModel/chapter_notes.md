`println` doesn't work like a string!

```
scala> val first = println("hi!")
hi!
                                                                                                                                                                              
scala> val second = println("there")
there
                                                                                                                                                                              
scala> first + second
-- [E008] Not Found Error: ---------------------------------------------------------------------------------------------------------------------------------------------------
1 |first + second
  |^^^^^^^
  |value + is not a member of Unit, but could be made available as an extension method.
  |
  |One of the following imports might make progress towards fixing the problem:
  |
  |  import scala.math.Fractional.Implicits.infixFractionalOps
  |  import scala.math.Integral.Implicits.infixIntegralOps
  |  import scala.math.Numeric.Implicits.infixNumericOps
  |
1 error found
                                                                                                                                                                              
scala> first
                                                                                                                                                                              
scala> second
                                                                                                                                                                              
scala> val fi = "hi!"
val fi: String = hi!
                                                                                                                                                                              
scala> val sec = "there"
val sec: String = there
                                                                                                                                                                              
scala> fi + sec
val res4: String = hi!there
                                                                                                                                                                              
scala> sec + fi
val res5: String = therehi!
                                                                                                                                                                              
scala> println("Happy birthday to you!")
Happy birthday to you!
                                                                                                                                                                              
scala> println("Happy birthday to you!")
Happy birthday to you!
                                                                                                                                                                              
scala> val happy = println("Happy birthday to you!")
Happy birthday to you!
                                                                                                                                                                              
scala> happy
                                                                                                                                                                              
scala> happy

```