package com.diedline.scala

import java.io.IOException

object ExceptionAndLazyValue {
  def main(args: Array[String]): Unit = {
    try {
      1/0
    }catch {
      case ioException: IOException => println("IO Exception" + ioException.toString)
      case illegalArgs:IllegalArgumentException => println("IllegalArgumentException" + illegalArgs.toString)
      case arithmeticException:ArithmeticException => println("ArithmeticException" + arithmeticException.toString)
    }
    //懒加载就是不将该值实例化 只有当它被使用的时候才会被实例化
    lazy val score = 100
    println("....." + score)
  }
}
