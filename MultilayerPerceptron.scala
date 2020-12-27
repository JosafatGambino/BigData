//MULTILAYER PERCEPTRON ALGORITHM

//Import the following libraries
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler

//This code is to avoid errors in the runs
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//This code is to know the performance of the algorithm (time and memory)
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//Creation of the MultilayerPerceptronClassifier object
object MultilayerPerceptronClassifierExample {

//Define main function
  def main(): Unit = {
    
//Start a spark session with the name "MultilayerPerceptronClassifier"
  val spark = SparkSession.builder.appName("MultilayerPerceptronClassifier").getOrCreate()

//Load information stored in the file bank.csv
val dataf = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("C:/Users/Admin/Desktop/Project Big Data/bank.csv")

//Fit on whole dataset to include all labels into the index
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(dataf)
val indexed = labelIndexer.transform(dataf).drop("y").withColumnRenamed("indexedLabel", "label")

//Create a new object Vector Assembler to the selected columns within an array 
val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")

//Use the Assembler object to transform "indexed" 
val features = assembler.transform(indexed)

//Create a new object StringIndexer to select columns and fit dataIndexed
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(indexed)
println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")
features.show()

// Data is divided into training and testing
val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

// The layers of the neural network are specified:
// The input layer is size 4 (features), two intermediate layers
// one whit size 5 and the other with size 4
// and 3 layers for output
val layers = Array[Int](5, 4, 1, 2)

// Set the training parameters
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Fit the model
val model = trainer.fit(train)

// Calculate the accuracy of test data
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")

//Calculate the test error.
val accuracy = evaluator.evaluate(result)
println(s"Test Error = ${(1.0 - accuracy)}")

//Memory
val mb = 0.000001
println("Used Memory: " + (runtime.totalMemory - runtime.freeMemory) * mb)
println("Free Memory: " + runtime.freeMemory * mb)
println("Total Memory: " + runtime.totalMemory * mb)
println("Max Memory: " + runtime.maxMemory * mb)

//Time
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000

    spark.stop()
  }
}