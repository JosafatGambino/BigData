// EVALUATIVE PRACTICE UNIT 2 - BIG DATA

//In the next set of instructions, each instruction contains the code fulfilling the corresponding purpose.

//1. Load in a dataframe _Iris.csv_ from https://github.com/jcromerohdz/iris, make data cleaning needed to be processed 
// by the following algorithm (Important, this cleaning must be done by means of a Scala script in Spark).
// a. Use the Mllib library of Spark the corresponding Machine Learning algorithm to multilayer perceived

    //Import required libraries, packages and APIs
    import org.apache.spark.sql.types.IntegerType
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.feature.StringIndexer 
    import org.apache.spark.ml.feature.VectorAssembler

    //Create a Spark session called "MultilayerPerceptonClassifier"
    val spark = SparkSession.builder.appName("MultilayerPerceptronClassifier").getOrCreate()

    //Load as Dataframe the file Iris.csv
    val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/Admin/Documents/9no Semestre/Git hub profe/iris/iris.csv")

//2. What are the names of the columns?
    dataf.columns // Column name

//3. How is the scheme?
    dataf.printSchema() // schema

//4. Print the first 5 columns.
    dataf.head(5) // Print the first 5 columns.

//5. Use the describe method () to learn more about DataFrame data.
    dataf.describe().show() // describe () 

//6. Make the relevant transformation for the categorical data which will beour labels to classify.
    
    //We fit the dataframe to categorical data.
    val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(dataf)
    val indexed = labelIndexer.transform(dataf).drop("species").withColumnRenamed("indexedLabel", "label")
    indexed.describe().show()

    //Create vector with the columns "sepal_length", "sepal_width", "petal_length", "petal_width"
    val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
    val features = assembler.transform(indexed)

    //Add metadata to the column "label".
    //Fit the dataset to include all the labels in the index.
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(indexed)
    println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")
    features.show

//7. Construct the classification models and explain their architecture.
    // First, we divide the data into train and test (70% for train and 30% for test)
    val splits = features.randomSplit(Array(0.7, 0.3), seed = 1234L)
    val train = splits(0)
    val test = splits(1)


    // We specify the layers of the dataframe:
    // The input layer is size 4 (features), two intermediate layers one whit size 5 and the other with size 4
    // and 3 layers for output
    val layers = Array[Int](4, 5, 4, 3)

    // Set the training parameters
    val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

    // Fit the model
    val model = trainer.fit(train)

    // Calculate the accuracy of test data
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//8. Print the results of the model
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
