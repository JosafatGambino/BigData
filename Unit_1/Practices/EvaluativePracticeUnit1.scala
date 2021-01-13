//1. Start a simple spark session.
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

//2. Load the Netflix Stock CSV file, have Spark infer the data types.
val dataNetflix = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3. What are the names of the columns? -> Date, Open, High, Low, Close, Volume, Adj Close
// You can use any of these two commands to get the name of the columns
dataNetflix.columns
dataNetflix.schema.names

//4. How is the scheme?
dataNetflix.printSchema()

//5. Print the first 5 columns.

for(i <- 0 to 4){
    dataNetflix.select(dataNetflix.schema.names(i)).show()
}

//6. Use describe() function to learn about the dataNetflixrame.
dataNetflix.describe().show()

/*7. Creates a new dataNetflixrame with a new column called "HV Ratio"
    which is the ratio between the price of the "High" column versus the "Volume"
    column of traded shares for a day.*/
val dataNetflix2 = dataNetflix.withColumn("HV Ratio", expr("High / Volume"))

dataNetflix2.show()

//8. Which day had the highest peak in the "Close" column?
dataNetflix.groupBy("Date","Close").max("Close").sort(desc("Close")).show(1)

//9. What is the meaning of the "Close" column?

// As the file appears to be about Netflix's stocks, the "close" column refers to the
// stock price at the close of the day.

//10. What is the maximum and minimum of the "Volume" column?
//The min and max functions were used to return the maximum and minimum value of the Volume column
dataNetflix2.agg(min("Volume"),max("Volume")).show()

//11. With Scala / Spark $ Syntax answer the following:
//a. A variable was created to store the result for days less than 600 in the Close column. The filter function was used.
val table = dataNetflix2.filter($"Close"<600) 

//Display result
table.count()

//b. What percentage of the time was the "High" column greater than $500?

//The quantity of the items in the column "High" is declared
val elementosHigh = dataNetflix2.select("High")

//The major elements of the column "High" are declared
val porcentaje = dataNetflix2.filter($"High">500)

//Result of percentage of time in column high above 500
val resultado = ((porcentaje.count.toDouble)/(elementosHigh.count.toDouble))*100

//c. What is the Pearson correlation between the "High" column and the "Volume" column?

//The corr function was used to obtain the Pearson correlation between the mentioned columns
dataNetflix2.select(corr("High","Volume")).show()

//d. What is the maximum "High" column per year?

//The Date and High columns were grouped together. The max() function was used to identify the maximum element in a descending manner.
dataNetflix2.groupBy(year($"Date")).agg(max($"High")).sort(year($"Date")).show()

//e. What is the average "Close" column for each calendar month?**

//The columns were grouped by month and column "Close". The avg() function was used to identify the average of the elements in a descending manner.
dataNetflix2.groupBy(month($"Date")).agg(avg($"Close")).sort(month($"Date")).show()