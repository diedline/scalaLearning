package com.diedline.scala


/**
  * scala类型系统编程实战
  * 1.scala的类和方法函数都可以是泛型，在spark源码中到处可以看到类和方法的泛型，在实际实例化的时候指定具体的类型例如spark最核心基础
  *   抽象的数据结构RDD里面关于RDD类的定义是泛型的，RDD中几乎所有方法的定义都是泛型的，之所以这么做是因为RDD会派生很多子类，通过子类
  *   适配不同的数据源和业务操作
  * 2.上边界表达了泛型的类型必须是某种类型，或者某种类型的子类，语法为 <:  这里的一个新的现象是对类型进行限定
  * 3.下边界表达了泛型的类型必须是某种类型，或者某种类型的父类，语法为 >:
  * 4.View Bounds，可以进行某种转化，将类型在没有知觉的情况下转换成目标类型，其实可以认为view bounds 是上下边界的加强版本,
  *   例如在SparkContext 中有T <% Writable方式的代码，这个代码表达的是T必须是Writable类型的，但T没有直接继承至writable接口，
  *   此时就需要通过 "implicate"的方式来实现这个功能；
  * 5.T：ClassTag,例如Spark 源码中的RDD class RDD[T:classTag] 这个其实也是一种类型转换系统，只是在编译的时候类型信息不够，需要借助
  *   于jvm的runtime来通过运行时信息获得完整的类型信息，这在spark时非常重要的，因为spark的程序的编程和运行时区分了
  * 6.逆变和协变；-T和+T
  * 7.Context Bounds 和 T: Ordering 这种语法必须能够编程Ordering[T]这种方式；
  * */
class Animal[T](val species:T){
  def getAnimal(species:T):T = species
}

class Person(val name:String){
  def talk(person:Person): Unit ={
    println(this.name + ":" + person.name)
  }
}

class Maximum[T: Ordering](val x: T,val y: T){

  def bigger(implicit ord:Ordering[T])  = {
    if(ord.compare(x, y) > 0) x else y
  }

}

//class Meeting[-T]
class Meeting[+T]
class Engineer
class Expert extends Engineer




// 可以使用<% 隐式转换成Person类
class Club[T <% Person](p1:T, p2:T){
  def communicate(): Unit = p1.talk(p2)

}





object TypeSystem {
  def main(args: Array[String]): Unit = {
    /*implicit def dog2Person(dog:Dog) = new Person(dog.name)

    val p = new Person("scala")
    val w = new Worker("spark")
    val dog = new Dog("huang")
    new Club(p,w).communicate()
    new Club[Person](p, dog).communicate()*/
    participateMeeting(new Meeting[Engineer])

    val expert = new Meeting[Expert]
    participateMeeting(expert)

    println(new Maximum[String]("scala","java").bigger)
  }

  def participateMeeting(meeting:Meeting[Engineer]){
    println("welcome")
  }


  class Worker(name:String) extends Person (name)
  class Dog(val name:String)
}
