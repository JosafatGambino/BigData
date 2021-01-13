//PRACTICE 1 - Linear Regression 

// Import libraries 
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession
import spark.implicits._

// The following code is to setup errors.
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Start a simple SparkSession
val spark = SparkSession.builder().appName("Practice1").master("local")getOrCreate()

//Create a path for use the csv file "Clean-Ecommerce"
val path = "C:/Users/Admin/Documents/9no Semestre/Git hub profe/BigData/Spark_Regression/Clean-Ecommerce.csv"

//Prints the schema of the dataframe:
//Load dataframe
val cleanE = spark.read.option("header", "true").option("inferSchema","true")csv(path)
//Prints schema
cleanE.printSchema 

//Prints a row of the dataframe
cleanE.show(1)

//// Dataframe setup to Machine Learning //////

//Import VectorAssembler y Vectors 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//// Transform the dataframe to take the form ("label","features") ////

//Steps

// 1) Rename the column "Yearly Amount Spent" as "label". Also of the data, just take the numeric column,
// Leave all this as a new DataFrame called "df"
val df = cleanE.select($"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership", $"Yearly Amount Spent".as("label"))

// 2)The Assembler object should convert the input values to a vector
// Use the VectorAssembler object to convert the input columns of "df"
// to a single output column of an array called "features"
// Configure the input columns of where we read the values.
val assembler = new VectorAssembler().setInputCols(Array("Avg Session Length","Time on App","Time on Website","Length of Membership")).setOutputCol("features")

//3)Use Assembler to transform our DataFrame to 2 columns: label and features
val dataf2 = assembler.transform(df).select($"label", $"features")
dataf2.show()

/////// Linear Regression /////////////

// Create a object to Linear regression model.  
val lr = new LinearRegression()

// Adjust the model for data and call to this model "lrModelo"
val lrModelo = lr.fit(dataf2)

// Summarize the model on the training set, print out some metrics.
// Use the summary method of our model to create an object called "trainingSummary"
val trainingSummary = lrModelo.summary

//Prints the coefficients and intercept to Linear Regression.
println(s"Coefficients: ${lrModelo.coefficients} Intercept: ${lrModelo.intercept}")

//Shows the residuals values, RMSE, MSE, and R^2.
trainingSummary.residuals.show()
println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
println(s"MSE: ${trainingSummary.meanSquaredError}")
println(s"r2: ${trainingSummary.r2}")