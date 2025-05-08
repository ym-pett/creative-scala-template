

@main def Matching(): Unit = {

    // // done: how can i see what it evaluates to? discuss, not sure I get 
    // 1 match {
    //     case a => a
    //     case b => b + 1
    //     case c => c * 2
    // }

    // get a long error message about matching, I think I've managed to make it not match, would be nice to have a clearer error message..
    // "x" match {

    //     case "a" => "yes!"
    //     case "b" => "no!"
    // }

    // done: same here, how to see all output?
    def double(n: Int): Int =
        n match {
            case 0 => 0
        case n => 2 + double(n-1)
    }

    // I'm not understanding this correctly, I feel it's doing:
        // case 0: 0
        // case 1: 2 + (1-1) = 2
        // case 2: 2 + (2-1) = 3
        // case 3: 2 + (3-1) = 4

        // 0 + 2 + 3 + 4 = 9??

        // whereas what it must be doing is 2 + 2 + 2

        


    println(double(3))
    
}

