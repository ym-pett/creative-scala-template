

@main def Matching(): Unit = {

    // // TODO: how can i see what it evaluates to? discuss, not sure I get 
    // 1 match {
    //     case a => a
    //     case b => b + 1
    //     case c => c * 2
    // }

    // get a long error message about matching, I think I've managed to make it not match, would be nice to have a clearer error message..
    "x" match {

        case "a" => "yes!"
        case "b" => "no!"
    }
    
}

