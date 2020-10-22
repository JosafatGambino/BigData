
//Practice 2
// 1. Create a list called "lista" with the elements "rojo", "blanco", "negro"
  val lista: List[String] = List("rojo", "blanco", "negro") 

// 2. Add 5 more elements to "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
  var lista2 = "verde" :: "amarillo" :: "azul" :: "naranja" :: "perla" :: lista

// 3. Get the "lista" elements "verde", "amarillo", "azul"
  
  //Current list
  print(lista2)
  List(verde, amarillo, azul, naranja, perla, rojo, blanco, negro)

  //Print elements verde-amarillo-azul
  print(lista2(0),lista2(1),lista2(2))

// 4. Create an array of numbers in the range 1-1000 in steps of 5 by 5
val numero = Array.range(0, 1000, 5)

// 5. What are the unique elements of the list List (1,3,3,4,6,7,3,7)? use conversion to sets
  val s1 = Set(1,3,3,4,6,7,3,7)
  s1: scala.collection.immutable.Set[Int] = Set(1, 6, 7, 3, 4)

// 6. Create a mutable map named names that contains the following
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
val nombres = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))
// 6 a . Print all keys on the map
nombres.keys

// 7 b . Add the following value to the map ("Miguel", 23)
nombres += ("Miguel" -> 23)