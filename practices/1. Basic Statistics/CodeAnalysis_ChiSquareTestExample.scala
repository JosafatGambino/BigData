//PRACTICE: CODE ANALYSIS ABOUT "CHI SQUARE TEST"

//Importar librerias
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
import org.apache.spark.sql.SparkSession

//An object is declared
object ChiSquareTestExample {

//Initializes a function
  def main(args: Array[String]): Unit = {
    
    //Create a simple SparkSession
    val spark = SparkSession.builder.appName("ChiSquareTestExample").getOrCreate()
    
    //Import library
    import spark.implicits._

    //Vector values are declared with the function seq for handling
    val data = Seq(
      (0.0, Vectors.dense(0.5, 10.0)),
      (0.0, Vectors.dense(1.5, 20.0)),
      (1.0, Vectors.dense(1.5, 30.0)),
      (0.0, Vectors.dense(3.5, 30.0)),
      (0.0, Vectors.dense(3.5, 40.0)),
      (1.0, Vectors.dense(3.5, 40.0))
    )

    //A dataframe is created with the columns called "label" and "features"
    val df = data.toDF("label", "features")
    
    //Null hypothesis or "ChiSquare Test" is created using the dataframe previously created with their respective columns
    val chi = ChiSquareTest.test(df, "features", "label").head
    println(s"pValues = ${chi.getAs[Vector](0)}")

    //Result of values "Degrees Of Freedom"
    println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
    
    //Result of values "Statistics"
    println(s"statistics ${chi.getAs[Vector](2)}")
    
    //Example off
    spark.stop()
  }
}
