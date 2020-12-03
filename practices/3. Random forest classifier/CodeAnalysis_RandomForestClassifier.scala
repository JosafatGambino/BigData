//PRACTICE: CODE ANALYSIS ABOUT "RANDOM FOREST CLASSIFIER"

//Import the following libraries
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.attribute.Attribute

//Upload and analyze the data file, converting it to a DataFrame.
//val data = spark.read.format("libsvm").load("C:\\Spark\\spark-2.4.7-bin-hadoop2.7\\data\\mllib\\sample_libsvm_data.txt")
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Index labels, adding metadata to the label column.
// Fit on whole dataset to include all labels in index.
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
val indexed =  labelIndexer.transform(data)

//Automatically identify "features" categorically and index them
//Set maxCategories so that "features" with > 4 distinct values are treated as continuous.
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

//Split the data into training and test sets (30% held out for testing).
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

//Train a Random Forest model.
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)

//Convert indexed labels back to original labels.
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels) 
  //Aqui marca error <console>:32: error: value labelsArray is not a member of org.apache.spark.ml.feature.StringIndexer
 // labelConverter.transform(indexed)

//Chain indexers and forest in a Pipeline.
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))

//Train model. This also runs the indexers.
val model = pipeline.fit(trainingData)

//Make predictions
val predictions = model.transform(testData)

//Select example rows to show.
predictions.select("predictedLabel", "label", "features").show(5)
//predictions.select("prediction", "rawPrediction", "indexedFeatures", "label", "features", "indexedLabel", "probability").show(5)

//Select (prediction, true label)
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

//Calculate the test error.
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

//Show by stages the classification of the random forest model
val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]
println(s"Learned classification forest model:\n ${rfModel.toDebugString}")