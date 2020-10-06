//Assessment 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
var perimetro = scala.io.StdIn.readDouble()

var radio = perimetro/(2 * Math.PI)

//3.Dada la variable bird = "tweet", utiliza interpolacion de string para
//  imprimir "Estoy ecribiendo un tweet"
var bird = "tweet"

print(s"Estoy escribiendo un $bird")

//5. Cual es la diferencia entre value y una variable en scala?

//Value es una constante, es decir no cambia a lo largo de la corrida del programa.
//Variable va cambiando dependiendo del codigo o de si el usuario le otorga otro valor.