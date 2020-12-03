//PRACTICE: CODE ANALYSIS ABOUT "SUMMARIZER"

//Import libraries
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer
import org.apache.spark.sql.SparkSession

//An object is declares
object SummarizerExample {
  
  //Initializes a function
  def main(args: Array[String]): Unit = {
    
    //Create a simple SparkSession
    val spark = SparkSession.builder.appName("SummarizerExample").getOrCreate()

    //Import libraries
    import spark.implicits._
    import Summarizer._

    //Vector values are declared with the function seq for handling 
    val data = Seq(
      (Vectors.dense(2.0, 3.0, 5.0), 1.0),
      (Vectors.dense(4.0, 6.0, 7.0), 2.0)
    )

    //A dataframe is created with the columns called "Features" y "weight"
    val df = data.toDF("features", "weight")

    //Values for mean and variance
    //Selected metrics (Mean, Variance)
    val (meanVal, varianceVal) = df.select(metrics("mean", "variance")

    //Summary method applied to "Features" and "Weight" metrics, is assigned an alias
      .summary($"features", $"weight").as("summary"))

    //Select "Summary" with its respective metric
      .select("summary.mean", "summary.variance")

    //The way you want to view or print
      .as[(Vector, Vector)].first()

    //Print to display Mean and Variance values
    println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")
    
    //Second value without using the Summary method
    val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
      .as[(Vector, Vector)].first()
    //Result
    println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
    
    //Example off
    spark.stop()
  }
}
