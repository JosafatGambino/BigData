## EVALUATIVE PRACTICE UNIT 3 - BIG DATA

**The objective of this practice is to try to group customers from specific regions of a wholesaler. This is based on sales of some product categories.**

In the next set of instructions, each instruction contains the code fulfilling 
the corresponding purpose.

### 1. Import a simple Spark session.

```scala
import org.apache.spark.sql.SparkSession
```

### 2. Use lines of code to minimize errors

```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

### 3. Create an instance of the Spark session

```scala
val spark = SparkSession.builder.getOrCreate()
```

### 4. Import the Kmeans library for the clustering algorithm.

```scala
import org.apache.spark.ml.clustering.KMeans
```

### 5. Loads the Wholesale Customers Data dataset

```scala
val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/Admin/Documents/9no Semestre/Datos Masivos/GitHubJosafatGambino/BigData/evaluation/Wholesale_customers_data.csv")
```

### 6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data

```scala
val feature_data = dataf.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")
feature_data.show
```
![]()

### 7. Import Vector Assembler and Vector

```scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.mllib.linalg.{Vector, Vectors}
```

### 8. Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels

```scala
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")
```

### 9. Use the assembler object to transform feature_data

```scala
val features = assembler.transform(feature_data)
```

### 10. Create a Kmeans model with K = 3

```scala
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)
```

### 11. Evaluate groups using Within Set Sum of Squared Errors WSSSE and print centroids.

```scala
val WSSSE = model.computeCost(features)
```
![]()

```scala
println(s"Within set sum of Squared Errors = $WSSSE")
```
![]()

```scala
//Print centroids
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```
![]()