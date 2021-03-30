

import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CleanData {
  def main(args: Array[String]): Unit = {
    // 为了避免执行过程中打印过多的日志
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("CleanData")
    val sc = new SparkContext(conf)
    
    // 读取数据
    val fileRDD = sc.textFile(args(0))
    
    // 清洗数据
    val cleanDataRDD = fileRDD.map(_.split(",")).filter(_(2).startsWith("http")).filter(_.length == 6)
    
    // 将清洗后的结果保存到HDFS
    cleanDataRDD.saveAsTextFile(args(1))
    
    // 停止SparkContext
    sc.stop()
    
    println("Finished")
  }
}