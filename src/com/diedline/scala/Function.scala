package com.diedline.scala


/**
  * 在scala中函数是一等公民，可以像变量一样传递，被赋值，同时函数可以赋值给变量，变量也可以赋值给函数
  * 之所以可以是这样，函数背后是类和对象，也就是说函数在运行的时候其实是一个变量，当然背后的类是scala帮我们生成的，可以天然的被序列化和反序列化
  * 1.可以天然的序列化和反序列的直接好处就是函数可以在分布式系统上传递！！！
  * 2.因为函数背后其实是类和对象，所以可以和普通的变量完全一样的应用在任何普通变量可以运行的地方，包括作为参数传递，作为返回值，被变赋值和
  * 赋值给变量等；
  *
  * 关于函数入门要点：
  * 1.def 函数关键字定义函数
  * 2.函数会自动进行类型推断来确定函数返回值的类型，如果函数名称和函数体之间没有等于号则类型推断失效，此时函数的类型是unit
  * 3.函数参数可以是函数
  * 4.如果函数无法推断具体的类型 必须声明类型 例如下面的fab函数
  * 5.函数的参数可以有默认值，这样在调用函数的时候如果不想返回默认值就直接不传递该参数直接使用默认值即可
  * 6.我们可以根据函数参数名称，调整函数参数的顺序，重点在于函数背后其实是类，其参数背后其实是类，其参数就是类的成员
  * 7.可变参数直接在参数列表中加* 传参时方便的语法 sum(1 to 1000: _*) 从 1 - 1000
  * 8.可变参数中的数据其实会被收集成Array数组，在我们入口方法中main中其实就是可变参数，是以array[String]的方式呈现的
  **/
object Function {
  def main(args: Array[String]): Unit = {
    hello("Spake", 31)
    println(hello("Spake", 31)) //函数参数可以是函数
    println(fab(5))

    println("Sum:" + sum(1,2,3,4,5))
    println("Sum:" + sum(1 to 1000: _*))


    println("sumrecursive:" + sumrecursive(1 to 10: _*))
  }

  def hello(name: String, age: Int = 30): Int = {
    println("Hello,MyName is " + name)
    println("My age  " + age)
    age
  }

  def fab(n: Long):Long = {
    if (n <= 1) 1
    else fab(n-2) + fab(n-1)
  }

  def sum(numbers : Int*):Int ={
    var result = 0
    for (number <- numbers)result += number
    result
  }

  def sumrecursive(numbers : Int*):Int = {
    if(0 == numbers.length) 0
    else numbers.head + sumrecursive(numbers.tail: _*)
  }
}
