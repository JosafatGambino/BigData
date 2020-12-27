//DECISION TREE ALGORITHM

//Import the following libraries
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.linalg.Vectors

//This code is to avoid errors in the runs
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//This code is to know the performance of the algorithm (time and memory)
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//An object is declared
object DecisionTree {
  def main(args: Array[String]): Unit = {

//Create a simple SparkSession  
val spark = SparkSession.builder.appName("DecisionTree").getOrCreate()

//Load information stored in the file bank.csv
val dataf = spark.read.option("header", "true").option("inferSchema","true").option("delimiter",";")csv("C:/Users/Admin/Desktop/Project Big Data/bank.csv")

// Fit on whole dataset to include all labels into the index
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(dataf)
val indexed = labelIndexer.transform(dataf).drop("y").withColumnRenamed("indexedLabel", "label")

//Create a new object Vector Assembler to the selected columns within an array 
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Use the Assembler object to transform "indexed" 
val features = vectorFeatures.transform(indexed)

//Rename column and select columns "label" & "features"
val featuresLabel = features.withColumnRenamed("y", "label")
val dataIndexed = featuresLabel.select("label","features")

//Create a new object StringIndexer to select columns and fit dataIndexed
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(dataIndexed)

// Automatically identify categorical features and then index them
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(dataIndexed)

//Split the data into training and test sets (30% held out for testing)
val Array(trainingData, testData) = dataIndexed.randomSplit(Array(0.7, 0.3))

//Train a Decision Tree model
val dtree = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

//Convert indexed labels back to original labels
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

//Chain indexers and tree in a Pipeline
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dtree, labelConverter))

//Train the model, this also runs the indexers
val model = pipeline.fit(trainingData)

//Make predictions
val predictions = model.transform(testData)

//Select example rows to show. In this case there was only the first 5 rows.
predictions.select("predictedLabel", "label", "features").show(5)

//Select(prediction, true label)
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

//Calculate the test error.
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

//Show by stages the classification of the tree model
val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n ${treeModel.toDebugString}")

//Memory
val mb = 0.000001
println("Used Memory: " + (runtime.totalMemory - runtime.freeMemory) * mb)
println("Free Memory: " + runtime.freeMemory * mb)
println("Total Memory: " + runtime.totalMemory * mb)
println("Max Memory: " + runtime.maxMemory * mb)

//Time
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000

  }
}