import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.{Vectors,Vector}
import org.apache.spark.mllib.classification.{SVMModel, SVMWithSGD}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import java.util.Properties
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

val train_data = sc.textFile("/home/han/Desktop/INFO7250/Final/dataset/machineLearning/train_after.csv")
val test_data = sc.textFile("/home/han/Desktop/INFO7250/Final/dataset/machineLearning/test_after.csv")

//LabeledPoint store labels and characters in supervised learning
//characters are: age_range,gender,merchant_id
val train= train_data.map{line =>
  val parts = line.split(',')
  LabeledPoint(parts(4).toDouble,Vectors.dense(parts(1).toDouble,parts
(2).toDouble,parts(3).toDouble))
}
val test = test_data.map{line =>
  val parts = line.split(',')
  LabeledPoint(parts(4).toDouble,Vectors.dense(parts(1).toDouble,parts(2).toDouble,parts(3).toDouble))
}
//train and iterate 1000 times. could also set other parameters here
val numIterations = 1000
val model = SVMWithSGD.train(train, numIterations)

model.clearThreshold()
val scoreAndLabels = test.map{point =>
  val score = model.predict(point.features)
  score+" "+point.label
}
scoreAndLabels.foreach(println)

model.clearThreshold()
val scoreAndLabels = test.map{point =>
  val score = model.predict(point.features)
  score+" "+point.label
}
//-----Store data-----
//set loyal buyer info
val rebuyRDD = scoreAndLabels.map(_.split(" "))
//set schema of spark data frame
val schema = StructType(List(StructField("score", StringType, true),StructField("label", StringType, true)))
//create row
val rowRDD = rebuyRDD.map(p => Row(p(0).trim, p(1).trim))
//build relationship between data and schema
val rebuyDF = spark.createDataFrame(rowRDD, schema)
//connect database
val prop = new Properties()
prop.put("user", "root") 
prop.put("password", "000000")
prop.put("driver","com.mysql.jdbc.Driver")
//append data to rebuy table
rebuyDF.write.mode("append").jdbc("jdbc:mysql://localhost:3306/dbtaobao", "dbtaobao.rebuy", prop)