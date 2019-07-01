object PartialFunction {
  def main(args: Array[String]): Unit = {
    val sample = 1 to 10
    val isEven:PartialFunction[Int,String] = {
      case x if x % 2 == 0 =>x + " is even"
    }
    isEven(4)
//    val evenNumber = sample collect isEven
//    evenNumber.foreach(println)

    val isOdd:PartialFunction[Int,String] = {
      case x if x % 2 == 1 => x + " is odd"
    }
    val numbers = sample map(isEven orElse isOdd)
    numbers.foreach(println)
  }
}
