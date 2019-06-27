

object CtrlStruct {
  /**
    * scala 语言特殊之处
    * 1.if是有返回值的
    * 2.返回值会自动判断类型  都为String 则为String 值不同则为any
    * 注意当你只写if的时候 相当于  else 另一个值为 {} Unit 类型 即Java 里面的void 类型  此时返回值为any
    * if(age >10) {"ss"} else {}
    * 如果你想要返回值为你所需要的类型时可以将else中的值设置成None
    * if(age > 10){"11"} else {None}
    * 3.if语句中如果右多条语句可以使用{}包裹，{}中的多条语句哪一条是计算结果 ===>最后一条就是返回值
    * 4.if 表达式可以用在for 循环中等其他控制结果中用于限制结果
    * */
  def main(args: Array[String]): Unit = {
    println("Scala")
    var age = 10
    val result = if(age > 25)"worker" else "Student"
    println(result)
    val result2 = if(age > 18)"Ads ult" else 1
    val result3 = if(age > 10)"ss"

    var x,y = 0
    val result4 = if(age < 18){
      x = x + 1
      y = y + 1
      x + y
    }else 0
    print(result4)

//    for(i <- 0 to 5 if i ==2){
//      println(i)
//    }

    /**
      * for循环是不断的循环一个集合，然后根据for{...}循环后面的代码块部分，
      * 会根据for循环（。。。）里提取的集合的item作为代码块的输入进行流程控制
      * 在for循环中能提取出什么内容取决于后面集合的类型！
      * 想跳出for循环方式 除了if 守卫以外还可以使用 return
      * */
    var sum = 0
//    for(i <- 0 to 6 if flag){
//      sum = sum + i
//      if(5 == i) flag = false
//    }

    for(i <- 0 to 6 ){
      sum = sum + i
//      if(5 == i) return   //return 返回是方法级别 这在实际开发中很常用
    }
    println("sum:", sum)
//    for( item <- "Hello Spark".split(" "))println(item)

    /**
      * while 循环也是循环集合来作为{...}的输入进而作为流程的控制while循环在实际server和Frame开发中至关重要
      * 例如让一个线程一直循环下去一般都会使用while；
      *
      * */
    import scala.util.control.Breaks._
    var flag = true
    breakable(
      while (flag){
        for(item <- "Spark"){
          println(item)
          if(item == 'r'){
            flag = false
            break()
          }
        }
      }
    )
  }
}
