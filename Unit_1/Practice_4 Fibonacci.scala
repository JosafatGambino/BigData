//Algorithm 1: Descendent recursive version

def fib(n:Int) : Int = { 
    if (n<2) { 
        return n
    }
    else { 
        return (fib(n-1) + fib(n-2)) 
    }
}
//Algorithm 2: Explicit formula version

def fib2(n:Int) : Double = {
    if(n<2) {
        return n
    }
    else {
        return ((1/math.sqrt(5)) * math.pow(((1+math.sqrt(5))/2), n) + (1/2))
    }
}

//Algorithm 3 Iterative version

def fib3(n:Int) : Int = {
    var a = 0
    var b = 1
    var c = 0

    for(i <- 1 to n){
        c = b + a
        a = b
        b = c
    }
    return a
}

//Algorithm 4: Iterative version with 2 variables

def fib4(n:Int) : Int = { 
    var a = 0 
    var b = 1 

    for(i <- 1 to n){ 
        b = b + a 
        a = b - a 
    }
}

//Algorithm 5: Iterative vector version

def fib5(n:Int) : Int = {
    var vector = new Array[Int](n+2)
    if(n<2){
        return n
    }
    else{
        for(i <- 1 to n+1){
            vector(i) = i
        }

        for(i <- 2 to n){
            vector(i) = vector(i-1) + vector(i-2)
        }
        return vector(n)
    }
}