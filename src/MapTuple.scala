import scala.collection.mutable

/***
  *
  * 1.默认情况下Map构造的不可变的集合，里面的内容不可修改，一旦修改就变成新的map，原有的map保持不变；
  * 2.map的实例时调用的apply
  * 3.如果想要直接New出Map实例则需要使用HashMap等具体的map子类
  * 4.spark很多配置也都是通过getOrElse来实现的
  * 5.使用sortedMap可以得到排序的集合
  * 6.LinkedHashMap可以记住插入的元素的顺序，这在实际开发中非常有用
  * 7.tuple 中可以有很多不同类型的数据 例如：("p1", "p2", 3)
  * 8.在企业级实际开发大数据的时候，一定会反复使用Tuple来表达数据结构，以及使用Tuple来处理业务逻辑
  * 9.tuple的一个重要的使用是作为函数的返回值，在tuple中返回若干个值
  * */
object MapTuple {
  def main(args: Array[String]): Unit = {
    val bigDatas = Map("Spark" -> 6,"Hadoop" -> 11)   //调用工厂方法来构造Map实例，注意map是接口
//    bigDatas("Spark") = 10
    val programingLanguage = scala.collection.mutable.Map("Scala" -> 13,"java" -> 23)
    programingLanguage("Scala") = 15
    for ((name,age) <- programingLanguage)println(name + " : " + age)
    //查询一个map的值一定时采用getOrElse的语法 一方面是不报异常 另外还有一个神奇的作用就是提供默认值 而关于默认值在实际开发中至关重要
    println(programingLanguage.getOrElse("python","null"))

    val persons = mutable.SortedMap(("jialingege", 30), ("dtspark", 1),("hadoop", 11))
    val personInf = new mutable.LinkedHashMap[String, Int]

    //添加值
    personInf += ("scala" -> 13, "java" -> 23, "python" -> 18)
    //删除值
    personInf -= "java"
    for((name,age) <- personInf)println(name + " : " + age)
    //通过keySet 来获取 所有key值
    for (key <- personInf.keySet)println(key)
    //使用values来输出values
    for (key <- personInf.values)println(key)

//    //通过yield 来重新生成map
//    val result = for((name, age)<- persionInf) yield (age, name)
//    for((age,name) <- result) println(age.toString + " : " + name)
    for((name,age) <- persons)println(name + " : " + age)
    var inf = ("p1", "p2", 3, 4, 5)
    //直接从tuple中获取值
    println(inf._3)
  }
}
