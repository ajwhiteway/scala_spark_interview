package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{explode, split, udf, lit, count}
import scala.concurrent.duration._
import  example.Helpers.Luhn

object ValidateCards {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("ValidateCards")
      .getOrCreate()

    import spark.implicits._

    // Add your code here
  }
}
