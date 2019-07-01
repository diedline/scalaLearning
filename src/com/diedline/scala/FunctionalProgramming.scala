package com.diedline.scala


/**
  * 函数式编程进阶：
  * 1.函数和变量一样作为scala语言作为scala的一等公民，函数可以直接赋值给变量
  * 2.函数更常用的方式是匿名函数 定义的时候只需要说明输入参数的类型和函数体即可，不需要名称，如果使用的时候一般会把匿名函数赋值给一个变量
  * (其实是val常量)spark 源码中大量存在这种语法
  * 3.函数可以作为参数直接传递给函数，这极大的简化了编程的语法
  *   第一：以前java的方式是new 一个接口实例，并在接口实例的回调方法中来实现业务逻辑，现在是直接将回调方法callback传递给函数，且在函数中直接
  *        使用，简化了代码编写，提升开发效率
  *   第二：这种方式适合编写复杂的业务逻辑和控制逻辑，对于机器学习，深度学习，图计算而言至关重要
  *   函数作为函数的参数的传递方式是称之为高阶函数的编程方式,spark 源码和应用程序开发中60%是这种代码
  * 4.函数式编程强大的原因，返回值可以是函数,当函数的返回类型是函数的时候，这个时候就表命scala的函数实现了闭包！
  *   scala闭包的内幕
  * 5.currying 复杂的函数式编程经常使用，可以维护变量在内存中的状态，且实现返回函数的链式功能，可以实现非常复杂的算法和逻辑
  *
 **/
object FunctionalProgramming {
  def main(args: Array[String]): Unit = {
    val hiData = hiBigData _
    hiData("spark")
    //匿名函数
    val f = (name: String) => println("hi " + name)
    f("kafka")

    //传递一个函数
    def getName(func: String => Unit, name:String): Unit ={
      func(name)
    }
    getName(f,"scala")

    Array(1 to 10: _*).map{(item:Int) => 2 * item}.foreach( x => println(x))

    def funcResult(message:String) = (name:String) => println(message + " "+ name)
    funcResult("hello")("Java") //currying 函数写法
  }

  def hiBigData(name: String) = {
    println("hi" + name)
  }

}
