//Practice 5 - Data frame

//This practice was done in order to work and study what a dataframe 
//is and how we can apply the different functions that Scala offers us:

// PRACTICE 5 - Using 15 functions with a data frame

//First the following lines of code were run before starting to use the 
//functions, each line of code contains a comment mentioning that each line 
//does.

//Importar SparkSession
 import org.apache.spark.sql.SparkSession

//Crear SparkSession
val spark = SparkSession.builder().appName("MiApp").master("local").getOrCreate()

//Importar SparkImplicits 
import spark.implicits._

//Cargar dataframe 
//Este data frame es un archivo de texto que contiene todo un dataset, entonces //esta línea de código toma la ruta para correrlo en la consola. 

val dataf = spark.read.csv("C:/Users/Admin/Documents/9no Semestre/Datos Masivos/Practicas/CitiGroup2006_2008")

//FUNCTIONS 

//Below are 15 functions with an explanation that each function applied in 
//the data frame created above.

//FUNCION #1
dataf.show() --> //This function show us the data frame. 

//FUNCTION #2
dataf.columns --> //This function shows the names of the columns created/existing in the data frame.

//FUNCTION #3
dataf.printSchema --> //This function shows the name of each column with its data type.

//FUNCTION #4
dataf.select("_c0","_c5").show() --> //This function shows the columns we select.

//FUNCTION #5 
val table = dataf.filter($"_c5">2000000)
table.show()  --> //This function creates a filter in the data frame using some condition. In this case, a filter was used in column _c5 where data greater than 2,000,000 are filtered

//FUNCTION #6
dataf.count() --> //This function tells us how many elements the data frame has.

//FUNCTION #7
dataf.head(3) --> //Displays the data sets, the number determines up to which data set of the data frame you want to display.

//FUNCTION #8
dataf.collect() --> //This function returns a vector containing all rows in the data frame.

//FUNCTION #9
dataf.describe("_c1").show() --> //This function displays the number of elements, mean, standard deviation, minimum, maximum data frame elements.

//FUNCTION #10
dataf.explain() --> //This function prints information about the data frame.

//FUNCTION #11
dataf.isEmpty --> //This function tells us if the data frame is empty. Returning a boolean value.

//FUNCTION #12
dataf.alias("$") --> //This function returns a new dataset with an alias set.

//FUNCTION #13
dataf.cube($"_c1",$"_c2").avg().show() --> //This function creates a multidimensional cube using specific columns.

//FUNCTION #14
dataf.inputFiles --> //Esta función retorna la información de la ruta de donde se ubica el dataset.

//FUNCTION #15
dataf.dtypes --> //Returns the column names and their data type, all in a vector.
