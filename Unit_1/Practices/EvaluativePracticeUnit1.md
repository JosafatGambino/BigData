## EVALUATIVE PRACTICE UNIT 1 - BIG DATA

In the next set of instructions, each instruction contains the code fulfilling 
the corresponding purpose. Adding the result in image format of the execution of 
the implemented lines of code.

### **1. Start a simple Spark session.** 
```scala
    //Import SparkSession
    import org.apache.spark.sql.SparkSession

    //Create SparkSession
    val spark = SparkSession.builder().appName("MiApp").master("local").getOrCreate()

    //Import SparkImplicits 
    import spark.implicits._ 
 ```

### **2. Load the Netflix Stock CSV file, have Spark infer the data types.**
```scala
    //Load dataframe
    val dataNetflix = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

    //The function show() show us the dataframe
    dataNetflix.show()
```
### **3. What are the names of the columns?**
```scala
    // You can use any of these two commands to get the name of the columns
    dataNetflix.columns
    dataNetflix.schema.names
```
### **4. How is the scheme?**
```scala
    //The printSchema function prints the data types of the content into the dataframe
    dataNetflix.printSchema 
    
    /*
    |-- Date: timestamp (nullable = true)
    |-- Open: double (nullable = true)
    |-- High: double (nullable = true)
    |-- Low: double (nullable = true)
    |-- Close: double (nullable = true)
    |-- Volume: integer (nullable = true)
    |-- Adj Close: double (nullable = true)
    */
```

### **5. Print the first 5 columns.**
```scala
    //You can use a for loop to print the name of the columns with the "columns" method
    for(i <- 0 to 4){
        println(dataNetflix.columns(i))
    }
```

### **6.Use describe() function to learn about the dataframe.**
```scala
    dataNetflix.describe().show()
```

### **7.  Creates a new dataframe with a new column called "HV Ratio" which is the ratio between the price of the "High" column versus the "Volume" column of traded shares for a day.**
```scala
    //A new dataframe was created with data from the previous dataframe by adding a new column called HV_Ratio. This column is the relationship between the High and Volume columns.
    //The dataNetflix2 variable was assigned the dataframe "dataNetflix" with the withColumn function to add the new required column and doing the division operation in the High and Volume columns.

    val dataNetflix2 = dataNetflix.withColumn("HV Ratio", expr("High / Volume"))

    //We use the "show" method to check that the dataframe was created correctly
    dataNetflix2.show()
```
### **8. Which day had the highest peak in the "Close" column?**
```scala
    //Shows the day the highest number was obtained in the Close column. The Date and Close columns were grouped, arranged in descending order, applying the max function and    only showing the first row.
        
    dataNetflix2.groupBy("Date","Close").max("Close").sort(desc("Close")).show(1)
```
### **9. What is the meaning of the Close "Close" column?**
```scala
    // As the file appears to be about Netflix's stocks, the "close" column refers to the
    // stock price at the close of the day.
```
