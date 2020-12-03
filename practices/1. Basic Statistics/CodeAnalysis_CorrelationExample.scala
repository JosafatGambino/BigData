//PRACTICE: CODE ANALYSIS ABOUT "CORRELATION" 

//Import libraries
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession

//An object is declared
object CorrelationExample {

//Initializes a function
  def main(args: Array[String]): Unit = {

    //Create a simple SparkSession
    val spark = SparkSession.builder.appName("CorrelationExample").getOrCreate()
    
    //Import library
    import spark.implicits._

    //Vector values are declared with the function seq for handling
    val data = Seq(
      Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
      Vectors.dense(4.0, 5.0, 0.0, 3.0),
      Vectors.dense(6.0, 7.0, 0.0, 8.0),
      Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
    )

    //A dataframe is created with the previously declared data and with column named "features"
    val df = data.map(Tuple1.apply).toDF("features")
    
    //Create correlation matrix
    val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
    //Result
    println(s"Pearson correlation matrix:\n $coeff1")
    
    //Create spearman correlation matrix
    val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
    //Result
    println(s"Spearman correlation matrix:\n $coeff2")
    
    //Example off
    spark.stop()
  }
}

