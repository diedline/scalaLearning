package com.diedline.scala

case class Person2(name: String, age: Int)

class DtCoder(val name:String, val salary:Int)

object DtCoder{
  def apply(name:String, salary:Int): Unit ={
    println("DTCoder apply method invoked!!!")
    new DtCoder(name,salary)
  }

//  def unapply(arg: DtCoder): Option[(String, Int)] =
}

object Extractor extends App {
  val person = Person2.apply("spark", 11) //调用apply工厂方法构造出类的实例对象
  val Person2(name, age) = person     //调用unapply方法把person实例中的name 和 age 属性提取出来并赋值Person2的成员
  println(name + " : " + age)

  person match {
    case Person2(`name`, `age`) => println("Wow " + name + ":" + age)
  }
}
