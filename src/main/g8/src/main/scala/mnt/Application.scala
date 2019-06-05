package mnt
import org.apache.spark.sql.SparkSession

object Application {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName(getClass.getSimpleName).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 1000)
    rdd.foreach(e => println(e))
    spark.close()

  }
}
