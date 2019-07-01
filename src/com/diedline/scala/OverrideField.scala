package com.diedline.scala


class Person1{
  val counter = 3
  val counterArray = new Array[Int](counter)
}

class Athlete extends Person1{
  override val counter = 5
}

object OverrideField extends App {
  val num = new Athlete()
    println(num.counterArray.length)
}
