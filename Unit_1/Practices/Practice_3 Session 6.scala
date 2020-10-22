//Practica3_Session6  #Code analysis

//This function determines each numeric element in the list if it is even or odd number 
def listEvens(list:List[Int]): String ={ //Function have as variable an integer type list and returns string value
    for(n <- list){  //For loop where n is equal every element in the list
        if(n%2==0){  //If the number of the list when divided by 2 leaves 0 residue
            println(s"$n is even") //Print value as even number
        }else{ 
            println(s"$n is odd") //Print value as odd number
        }
    }
    return "Done" //Returns "Done" when the list is finished  
}

val l = List(1,2,3,4,5,6,7,8) //Integer type values are declared in the list named "l"
val l2 = List(4,3,22,55,7,8) //Integer type values are declared in the list named "l2"
listEvens(l) //The function is executed with the values in the "l" list
listEvens(l2) //The function is executed with the values in the "l2" list

//3 7 afortunado
//This function determines the result number of trades based on the given conditions, if the number is equal to 7.  
//Finally the lucky number is 29.
def afortunado(list:List[Int]): Int={ //Function have as variable an integer type list and returns integer value 
    var res=0 //Initializes res variable 
    for(n <- list){ //For loop where n is equal every element in the list
        if(n==7){ //If n is equal to 7 
            res = res + 14 //then adds 14 to res variable
        }else{ 
            res = res + n //else adds to the variable res the number of the list that entered to be evaluated in the function 
        }
    }
    return res //Returns res value 
}

val af= List(1,7,7) //Variable af is declared as a list with three integer type elements 
println(afortunado(af)) //Print the lucky number as result of the function 


//This function determines if the first and second variables get the same results at the end of each iteration. 
//That is, each iteration makes a addition operation on the first variable and the second variable does a 
//subtraction operation. Doing so creates new results that, when added together, give the same result between the two. 

def balance(list:List[Int]): Boolean={ //Function have as variable an integer type list and returns boolean value 
    var primera = 0 //Initializes the first variable 
     var segunda = 0 //Initializes the second variable 

    segunda = list.sum //The second variable is equal to the addition of the elements of the list.

    for(i <- Range(0,list.length)){ //For loop where where it starts at 0 to the size of the list in iterations 
        primera = primera + list(i) //The first variable is equal a the first variable more element of the list 
        segunda = segunda - list(i) //The second variable is equal a the second variable less element of the list 

        if(primera == segunda){ //If the first variable is equal to the second variable so returns true 
            return true   
        }
    }
    return false //else returns false 
}

val bl = List(3,2,1) //bl is declared as a list of three elements of type int
val bl2 = List(2,3,3,2) //b12 is declared as a list of three elements of type int
val bl3 = List(10,30,90) //b13 is declared as a list of three elements of type int

balance(bl) //Runs function with values from the bl list 
balance(bl2) //Runs function with values from the bl2 list 
balance(bl3) //Runs function with values from the bl3 list 


//This function gives as boolean result if the word entered is backwards the same  
def palindromo(palabra:String):Boolean ={ //Function with string type variable and returns boolean value 
    return (palabra == palabra.reverse) //Returns true if the word entered is the same backwards   
}

val palabra = "OSO" //"palabra" variable declared
val palabra2 = "ANNA" //"palabra2" variable declared
val palabra3 = "JUAN" //"palabra3" variable declared

println(palindromo(palabra)) //Print true or false if the word is the same backwards 
println(palindromo(palabra2)) //Print true or false if the word is the same backwards 
println(palindromo(palabra3)) //Print true or false if the word is the same backwards 
