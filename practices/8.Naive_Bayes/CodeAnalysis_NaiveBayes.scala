//Import NaiveBayes and MulticlassClassificationEvaluator libraries
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Load data from dataframe
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

//Split data into training and test data
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)

// Fit the NaiveBayes model
val model = new NaiveBayes().fit(trainingData)

// Create the predictions from test model
val predictions = model.transform(testData)
predictions.show()

// Create evaluator from label and prediction as accuracy
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)

println(s"Test set accuracy = $accuracy")