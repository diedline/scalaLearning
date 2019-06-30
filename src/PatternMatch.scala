
class DataFrameWork
case class ComputationFrameWork(name:String,popular:Boolean) extends DataFrameWork
case class StorageFrameWork(name:String,popular:Boolean) extends DataFrameWork

object PatternMatch {
  def main(args: Array[String]): Unit = {
//    getSalary("sdasda",6)
//    getMatchType("100.1")
//    getMatchCollection(Array("spark","python"))
//    getBigData(ComputationFrameWork("Spark",popular = true))
//    getBigData(StorageFrameWork("Spark",popular = true))
    getValue("Spark",Map("Spark" -> "the hottest","hadoop" -> "the oldest"))
  }

  //通过模式匹配具体的值
  def getSalary(name:String,age:Int) ={
    name match {
      case "Spark" => println("$150000/year")
      case "Hadoop" => println("$100000/year")
      case _ if name == "scala" => println("$140000/year")
      case _ if name == "hadoop MapReduce" => println("$90000/year")
      case _name if age >= 5  => println(_name + "," + age + "$120000/year")
      case _ => println("$80000/year")
    }
  }

  //通过模式匹配匹配数据类型
  def getMatchType(msg:Any): Unit ={
    msg match {
      case i:Int => println("Integer")
      case s:String => println("String")
      case d:Double => println("Double")
      case _ => println("unKnowType")
    }
  }

  //通过模式匹配来匹配数组
  def getMatchCollection(msg:Array[String]): Unit ={
    msg match {
      case Array("scala") => println("oneEle")
      case Array("scala", "java") => println("twoEle")
        //可以使用_* 代表任意数量的元素
      case Array("spark", _*) => println("manyEle")
      case _ => println("UnKnow Type")
    }
  }

  //通过模式匹配来匹配对应的类
  def getBigData(data:DataFrameWork): Unit ={
    data match {
      case ComputationFrameWork(name, popular) => println("ComputationFrameWork " + "name:" + name + ": popular:" + popular)
      case StorageFrameWork(name, popular) => println("StorageFrameWork" + "name:" + name + ": popular:" + popular)
      case _ => println("some Other Type")
    }
  }

  //通过模式匹配来获取 map里面是否包含对应的key
  def getValue(key:String, content: Map[String,String]): Unit ={
    content.get(key) match {
      case Some(value) => println(value)
      case None => println("not found")
    }
  }

}
