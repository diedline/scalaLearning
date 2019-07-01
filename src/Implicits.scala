
class Man(val name:String)

/**
  * 在object中做隐式转换将Man对象转换成SuperMan,当使用Man对象的时候会调用转换方法变成SuperMan
  * */
//object Man{
//  implicit def man2SuperMan(man:Man) = new SuperMan(man.name)
//}

class SuperMan(val name:String){
  def makeMiracles = println(this.name + ": Wow,wow")
}

/**
  * 在实现类里面导入这个类也能实现隐式转换
  * */
object implicts{
  implicit def man2SuperMan(man:Man) = new SuperMan(man.name)
}

object Implicits {
  def main(args: Array[String]): Unit = {
    val man = new Man("scala")
    import implicts._
    man.makeMiracles

    //可以在隐式属性使用implicit 然后在实现的方法中 加上那个参数作为默认值，在调用那个方法的时候就不需要参数了
    implicit val content = "money"
    talk("scala")
  }

  def talk(name:String)(implicit content:String) = println(name + ":" + content)
}
