package com.diedline.scala


abstract class Person1{
  val counter :Int
  val counterArray = new Array[Int](counter)
}

class Athlete extends Person1{
  override val counter = 5
}

class Programmer(val name:String, val salary:Double){

  //覆写equals 如果姓名和薪水一样则认为是同一人
  override def equals(obj: Any): Boolean = {
    val that = obj.asInstanceOf[Programmer]
    if(that == null)false
    else name == that.name && salary == that.salary
  }
  //一般覆写equals方法  都要覆写hashCode方法
  override def hashCode(): Int = name.hashCode * 17 + salary.hashCode() * 9
}

//因为scala在定义的时候发现覆写就会Array的中的值变为0 然后后面定义的值就不会生效
//所以需要提前定义 要修改的值不然修改不会生效
//class Athlete extends{
//  override val counter = 5
//}with Person1


object OverrideField extends App {
  val num = new Athlete()
    println(num.counterArray.length)
}
