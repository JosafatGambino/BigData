// Import libraries for one vs rest classifier
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Load data from txt file
var inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

// Divide the data into train and test
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))

// Create base classifier
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)

// Create one vs rest classifier
val ovr = new OneVsRest().setClassifier(classifier)

// Fit the train model
val ovrModel = ovr.fit(train)

// Create the predictions from test model
val predictions = ovrModel.transform(test)

// Create evaluator from accuracy
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// Calculates the classification error in the test data.
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")