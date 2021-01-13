//Practice 1
//1. Develop a scala algorithm that calculates the radius of a circle
    var perimetro = scala.io.StdIn.readDouble()

    var radio = perimetro/(2 * Math.PI)

//2. Develop an algorithm in Scala that determines if a number is prime 

   //Function for get prime numbers 
   def NumPrim(i: Int) : Boolean = { 
   if(i <= 1) false else if (i==2) true 
   else !(2 to (i-1)).exists(x => i % x == 0) }

  //Print results
  (1 to 120).foreach(i => if(NumPrim(i)) println("%d es primo".format(i))
  else println("%d no es primo".format(i)))

//3. Given the variable bird = "tweet", use string interpolation to print "Estoy escribiendo un tweet"
      var bird = "tweet"

     print(s"Estoy escribiendo un $bird")

//4. Given the variable message = "Hola Luke, ¡yo soy tu padre!", use "SLICE" to extract the sequence "Luke"

    //The variable cadena 
    var cadena = "Hola Luke, ¡yo soy tu padre!"
   //Using slice to get the word "Luke" 
    cadena.slice(7,9)

//5. What is the difference between value and a variable in scala?

   //Value is a constant, that is, it does not change throughout the program's run.
   //Variable changes depending on the code or if the user gives it another value.

//6. Given the tuple (2,4,5,1,2,3,3.1416,23), return the 3.1416 number

    //Create a list of numbers
    val numbers = List(2,4,5,1,2,3,3.1416,23)
    //Print number 3.1416
    println(numbers(6))