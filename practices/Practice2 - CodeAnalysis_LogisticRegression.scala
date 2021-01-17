//PRACTICE 2 - Code Analysis: Logistic Regression 

////////////////////////
///   Take data  //////
//////////////////////

// Import a SparkSession with the Logistic Regression library
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
// Use the Error reporting code
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
// Create a Spark session
val spark = SparkSession.builder().getOrCreate()
// Use Spark to read the Advertising csv file.
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")
// Print the Dataframe Schema
data.printSchema()

//////////////////////////
//// Deploy the data ////
////////////////////////

// Print an example line

data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
/////////////////////////////////////////////////////
//// Prepare the DataFrame for Machine Learning ////
///////////////////////////////////////////////////


// - Create a new column called "Hour" from the Timestamp containing the "Hour of the click"
val timedata = data.withColumn("Hour",hour(data("Timestamp")))
// - Rename the column "Clicked on Ad" to "label"
// - Take the following columns as features "Daily Time Spent on Site", "Age", "Area Income", "Daily Internet Usage", "Timestamp", "Male"
val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")

// Import VectorAssembler y Vectors
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// Create a new VectorAssembler object called assembler for the features
val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))

                  // Use randomSplit to create 70/30 split test and train data
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)


///////////////////////////////
//  Set up a Pipeline  ///////
/////////////////////////////

// Import  Pipeline
import org.apache.spark.ml.Pipeline
// Create a new LogisticRegression object called lr
val lr = new LogisticRegression()
// Create a new pipeline with the elements: assembler, lr
val pipeline = new Pipeline().setStages(Array(assembler, lr))
// Fit the pipeline for the training set.
val model = pipeline.fit(training)
// Take the Results in the Test set with transform
val results = model.transform(test)

////////////////////////////////////
//// Model evaluation /////////////
//////////////////////////////////


// For Metrics and Evaluation import MulticlassMetrics
import org.apache.spark.mllib.evaluation.MulticlassMetrics
// Convert test results to RDD using .as and .rdd
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
// Initialize a MulticlassMetrics object
val metrics = new MulticlassMetrics(predictionAndLabels)

// Print the Confusion matrix
println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy