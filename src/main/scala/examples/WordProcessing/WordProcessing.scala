package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{explode, split, udf}
import scala.concurrent.duration._

object WordProcessing {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("WordCount")
      .getOrCreate()

    import spark.implicits._

    // normalize to lowercase
    val normalize = udf((s: String) => s.trim.toLowerCase)

    val lines = Seq("A b", "b C", null).toDF("line")
    lines.show()
    Thread.sleep(5.seconds.toMillis)
    val words = lines.select(explode(split($"line", " ")).as("word"))
    val normalized = words.withColumn("norm", normalize($"word"))
    
    normalized.show()
    Thread.sleep(5.seconds.toMillis)

    val counts = normalized.groupBy("word").count()

    counts.show(10)

    spark.stop()
  }
}
