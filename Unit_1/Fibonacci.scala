//Algoritmo 1 Versión recursiva descendente

def fib(n:Int) : Int = {
    if (n<2) {
        return n
    }
    else {
        return (fib(n-1) + fib(n-2))
    }
}

//Algoritmo 2 Versión con fórmula explícita (6)

def fib2(n:Int) : Double = {
    if(n<2) {
        return n
    }
    else {
        return ((1/math.sqrt(5)) * math.pow(((1+math.sqrt(5))/2), n) + (1/2))
    }
}

//Algoritmo 3 Versión iterativa

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

//Algoritmo 4 Versión iterativa 2 variables

def fib4(n:Int) : Int = {
    var a = 0
    var b = 1

    for(i <- 1 to n){
        b = b + a
        a = b - a
    }
    return a
}

//Algoritmo 5 Versión iterativa vector

def fib5(n:Int) : Int = {
    var vector = new Array[Int](n)
    if(n<2){
        return n
    }
    else{
        for(i <- 1 to n){
            vector(i-1) = i
        }

        for(i <- 2 to n+1){
            vector(i) = vector(i-1) + vector(i-2)
        }
        vector(n)
    }
}