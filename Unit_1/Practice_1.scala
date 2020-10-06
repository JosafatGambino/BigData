//Practice 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
    var perimetro = scala.io.StdIn.readDouble()

    var radio = perimetro/(2 * Math.PI)

//2. Desarrollar un algoritmo en Scala que me diga si un numero es primo 

   //Function for get prime numbers 
   def NumPrim(i: Int) : Boolean = { 
   if(i <= 1) false else if (i==2) true 
   else !(2 to (i-1)).exists(x => i % x == 0) }

  //Print results
  (1 to 120).foreach(i => if(NumPrim(i)) println("%d es primo".format(i))
  else println("%d no es primo".format(i)))

//3.Dada la variable bird = "tweet", utiliza interpolacion de string para
  //  imprimir "Estoy ecribiendo un tweet"
      var bird = "tweet"

     print(s"Estoy escribiendo un $bird")

//4. Dada la variable mensaje = "Hola Luke, ¡yo soy tu padre!", utiliza "SLICE" para extraer la secuencia "Luke"

    //The variable cadena 
    var cadena = "Hola Luke, ¡yo soy tu padre!"
   //Using slice to get the word "Luke" 
    cadena.slice(7,9)

//5. Cual es la diferencia entre value y una variable en scala?

   //Value es una constante, es decir no cambia a lo largo de la corrida del programa.
   //Variable va cambiando dependiendo del codigo o de si el usuario le otorga otro valor.

//6. Dada la tupla (2,4,5,1,2,3,3.1416,23), regresa el numero 3.1416

    //Create a list of numbers
    val numbers = List(2,4,5,1,2,3,3.1416,23)
    //Print number 3.1416
    println(numbers(6))