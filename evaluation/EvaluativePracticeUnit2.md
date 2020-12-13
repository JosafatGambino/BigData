
## EVALUATIVE PRACTICE UNIT 2 - BIG DATA

In the next set of instructions, each instruction contains the code fulfilling 
the corresponding purpose.

### 1. Load in a dataframe _Iris.csv_ from https://github.com/jcromerohdz/iris, make data cleaning needed to be processed by the following algorithm (Important, this cleaning must be done by means of a Scala script in Spark).
###  a. Use the Mllib library of Spark the corresponding Machine Learning algorithmto multilayer perceived

```scala
 //Import required libraries, packages and APIs
    //Importar las librerias, paqueterias y APIs necesarias.
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
```

### 2. What are the names of the columns?

```scala
 dataf.columns
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image01.png)

### 3. How is the scheme?

```scala
 dataf.printSchema()
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image02.png)

### 4. Print the first 5 columns.

```scala
dataf.head(5)
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image03.png)

### 5. Use the describe method () to learn more about DataFrame data.

```scala
dataf.describe().show()
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image04.png)

### 6. Make the relevant transformation for the categorical data which will beour labels to classify.

```scala
    //We fit the dataframe to categorical data. 
    val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(dataf)
    val indexed = labelIndexer.transform(dataf).drop("species").withColumnRenamed("indexedLabel", "label")
    indexed.describe().show()
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image05.png)

```scala
    //Create vector with the columns "sepal_length", "sepal_width", "petal_length", "petal_width"
    val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
    val features = assembler.transform(indexed)

    //Add metadata to the column "label".
    //Fit the dataset to include all the labels in the index.
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(indexed)
    println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")
    features.show
```
![](https://github.com/JosafatGambino/BigData/blob/Unit_2/images/evaluation/image06.png)

### 7. Construct the classification models and explain their architecture.

### 8. Print the results of the model







