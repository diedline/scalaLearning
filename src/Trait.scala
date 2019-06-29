

trait Logger{
  def log(message:String): Unit ={
    println("logger:" + message)
  }
}

trait RichLogger extends  Logger {
  override def log(message:String): Unit ={
    println("RichLogger:" + message)
  }
}

class Login(val name:String) extends Logger{
  def loggin: Unit ={
    println("hello,Welcome !" + name)
    log(name)
  }
}

trait Information {
  def getInf:String
  def checkIn:Boolean = {
    getInf.equals("spark")
  }
}

class Passenger(val name:String)extends Information {
  override def getInf: String = name
}


object Trait {
  def main(args: Array[String]): Unit = {
//    new Login("DTSpark").loggin
    //当你使用with 来使用一个新的接口时，新接口的方法会覆盖之前的方法
    val person = new Login("DTSpark") with RichLogger
    person.loggin
  }
}
