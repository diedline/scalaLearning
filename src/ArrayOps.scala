import scala.collection.mutable.ArrayBuffer

/**
  * 大数据是数据的集合以及对数据集合的操作技术的统称，具体来说：
  * 1.数据集合：会涉及数据的搜集，存储等，搜集会有很多技术，存储现在流行的是使用Hadoop，也有很多情况使用kafka
  * 2.对数据集合的操作技术：spark
  *
  * spark的框架实现语言是scala，首选应用程序开发也是scala，所以scala对集合操作的的支持就至关重要，并且异常强大
  * spark对很多数据的操作的算子和scala中对集合操作的算子是一样的，掌握了Scala中集合的操作基本上就可以直接开发spark代码
  *
  * 关于scala中数组的创建
  * 1.最原始的创建数组的方式 new Array[Int](5) 指定类型int 长度5
  * 2.数组下标从0开始,对数组元素访问的时候下标额范围在0到length -1 的 范围 超过Length -1 会出现数组越界的错误
  * 3.最常用和最经典的创建数组的方式是形如 val array = Array[Int](1,2,3,4,5)，直接通过array类名并传递参数的方式来创建类实例,
  * 在背后是实现是调用工厂方式apply来构建出数组以及数组的内容
  * 4.关于array本身在底层的实现是使用jvm java数组的实现
  * 5.如果想使用可变数组的话首先需要导入 import  scala.collection.mutable.ArrayBuffer
  * 6.关于arrayBuffer增加元素的情况默认情况下都是在末尾增加元素的,效率非常高
  * 7.当需要多线程并发操作的时候,arrayBuffer转换成array就非常重要，其实即使是array其本生也不可变动，
  *   但我们可以修改array中每个元素的内容，所以多线程操作的时候还是需要考虑并发执行
  * 8.如果想在已经有的数组的基础上通过作用于每个元素来生成新的元素构成的新数组，则可以通过yield 来完成，这在大数据中意义重大
  *   第一点：是在不修改已有的array的基础上完成的，非常适合大数据的处理
  *   第二点：在大数据处理中spake业务操作的核心思想类似于yield,来通过使用function对每个元素操作获得新的元素获得新的集合，其实就是新的RDD,
  *   例如MapPartitionsRDD
  * 9.集合操作往往能通过丰富的操作算子，例如通过filter来过滤，map来进行每一个元素的加工
  **/
object ArrayOps {
  def main(args: Array[String]): Unit = {
    //    val array = new Array[Int](5) //定义数组第一种方式
    //    val array = Array[Int](1,2,3,4,5) //第二种直接给数组赋值，在这里能去掉int这个泛型是因为scala具有类型
    //    推导的能力，而我们已经传进了当前数组Array的值
    val array = Array.apply(1, 2, 3, 4, 5)
    array(0) = 10
    //    array(5) = 1  //数组下标越界
    for (item <- array) println(item)
    val name = Array("scala", "spark", "kafka")
    val arrayBuffer = ArrayBuffer[Int]()
    arrayBuffer += 1
    arrayBuffer += 2
    arrayBuffer += 3
    arrayBuffer += (4, 5, 6, 7, 8, 9, 10)
    arrayBuffer.addAll(Array(1,2,3))
    arrayBuffer.insert(arrayBuffer.length - 1, 1000)
    arrayBuffer.remove(arrayBuffer.length - 1)
    //当需要进行多线程操作的时候把ArrayBuffer转换成array就非常重要
    arrayBuffer.toArray
    for (item <- arrayBuffer) println(item)
    //将i从 0 到最后都打印出来
    for(i <- array.indices)print(i + " ")
    println(" ")
    for(i <- 0 until(array.length, 2) )print(i + " ")
    //使用reverse 来从后往前打印输出
    for(i <- (0 until(array.length)).reverse )println(i + " ")
    //求和
    println("Sum:", array.sum)
    println("max:", array.max)
    //快速排序    对数组进行升序排序   内容变成了2,3,4,5,10
    scala.util.Sorting.quickSort(array)
    //输出为字符串
    println("quickSort", array.mkString(","))
    val arrayAddOne = for(item <- array) yield item + 1
    println(arrayAddOne.mkString(","))

    val arrayEven = for(item <- array if item % 2 == 0) yield  item + 1
    println(arrayEven.mkString(","))
    //可以使用filter来过滤出需要的元素  可以使用_来代替 x => x
    println(array.filter(x => x % 2 == 0).mkString(","))
    println(array.filter{ _% 2 == 0}.mkString(","))
    println(array.filter{ _% 2 == 0}.map( _* 10).mkString(","))
  }
}
