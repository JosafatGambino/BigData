//1. Import a simple Spark session.
import org.apache.spark.sql.SparkSession
//2. Use lines of code to minimize errors
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
//3. Create an instance of the Spark session
val spark = SparkSession.builder.getOrCreate()
//4. Import the Kmeans library for the clustering algorithm.
import org.apache.spark.ml.clustering.KMeans
//5. Loads the Wholesale Customers Data dataset
val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale_customers_data.csv")
//6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data
val feature_data = dataf.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")
feature_data.show