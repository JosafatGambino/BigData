// Import the MultilayerPerceptronClassifier and MulticlassClassificationEvaluator libraries
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
// $example off$
// Import SparkSession library
import org.apache.spark.sql.SparkSession

/**
 * An example for Multilayer Perceptron Classification.
 */

 // Creation of the MultilayerPerceptronClassifier object
object MultilayerPerceptronClassifierExample {

// Define main function
  def main(): Unit = {
    // Start a spark session with the name "MultilayerPerceptronClassifierExample"
    val spark = SparkSession
      .builder
      .appName("MultilayerPerceptronClassifierExample")
      .getOrCreate()

    // $example on$
    // Load the data in libsvm format from the file as a DataFrame
    val data = spark.read.format("libsvm")
      .load("sample_multiclass_classification_data.txt")

    // Data is divided into training and testing
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)

    // The layers of the neural network are specified:
    // The input layer is size 4 (features), two intermediate layers
    // one whit size 5 and the other with size 4
    // and 3 layers for output
    val layers = Array[Int](4, 5, 4, 3)

    // Set the training parameters
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)

    // Fit the model
    val model = trainer.fit(train)

    // Calculate the accuracy of test data
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator()
      .setMetricName("accuracy")

    // Print the model
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
    // $example off$

    spark.stop()
  }
}