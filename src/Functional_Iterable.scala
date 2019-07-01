import scala.collection.mutable

/**
  *
  * 1.在Scala 集合体系中iterable是公共的trait,Iterable 要求继承者实现一些共同的方法，例如对元素的遍历等
  * 2.Array是一个基础的数据结构，不从属于Scala集合的体系
  * 3.scala的集合体系中，集合分为可变集合和不可变集合;不可变的集合在immutable包中，可变的集合在mutable包中
  * 4.lists是元素的列表集合，是不可变的
  *   第一点：list head指第一个元素，tail指剩下的元素构成的List集合
  *   第二点：使用：：来把List和元素进行组拼，来构建出新的list
  *   第三点：如何集合中没有元素的话，此时为Nil,例如集合中是由一个元素。head就是那个元素,tail会返回Nil
  * 5.可变列表 LinkedList
  * 6.set 是元素不可重复的集合，且元素无序的
  * 7.HashSet中的元素不可变且不可重复且不能够保证顺序
  * 8.使用LinkedHashSet能维护元素插入的顺序
  * 9.使用sortedSet能自动将插入的元素进行排序
  * */
object Functional_Iterable {
  def main(args: Array[String]): Unit = {
    //    val range = 1 to 10
    //    val list = List(1,2,3,4,5)
    //    println(list.head)
    //    println(list.tail)
    //    println(0::list)
    //    var linkedList = scala.collection.mutable.LinkedHashSet(1,2,3,4,5)
    //    println(linkedList.tail)
    //    while (linkedList.nonEmpty){
    //      println(linkedList.head)
    //      linkedList = linkedList.tail
    //    }
    //
    //    val set = Set(1,2,3,4,5)
    //    println(set)
    //    //元素不可重复
    //    val setMore = set + 1
    //    println(setMore)
    //
    //    //使用hashSet
    //    val hashSet = mutable.HashSet(1,3,2,4,5)
    //    hashSet += 5
    //    hashSet += 6
    //    println(hashSet)
    //
    //    //排序的Set
    //    val sortedSet = mutable.SortedSet(1,3,2,5,4)
    //    println(sortedSet)


    println(List("i am good in spark!", "scala is powerful").flatMap(x => x.split(" ")).map(x => (x,1)).map(x => x._2))
    //使用reduce _+_ 累加 不知道为啥Idea会报错但编译是成功的
    println(List("i am good in spark!","scala is powerful").flatMap(x => x.split(" ")).map((_,1)).map(_._2).reduce(_ + _))
    List(1 to 10).foreach(x => println(x))
    //使用占位符直接打印输出
    List(1 to 10).foreach(println(_))
    //进一步简化
    List(1 to 10).foreach(println)
  }
}
