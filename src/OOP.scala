
/**
  * 1.定义类使用class
  * 2.使用new 来创建对象
  * 3.如果名称相同，那么object中的内容都是class的静态内容，也就是说object中的内容，class都可以在没有实例的时候直接调用
  * 正是因为可以在没有类实例的时候调用object中一切内容，所以可以使用object中特定方法来创建类实例，而这个特定方法就是apply
  * 4.obj中的apply是class类的工厂方法，用于控制对象的生成
  * 5.很多框架的代码一般直接调用抽象类object 的apply方法来生成类的实例对象
  * 第一：其秘诀在于apply具有类生成的一切生杀大权，抽象类是不可以实例化的，在apply方法可以实例化抽象类的子类，以spark中的图计算为例
  * Graph是抽象的class，在object Graph中的apply方法实际上是调用了Graph的子类GraphImpl来构建Graph类型对象的实例
  * 第二：效应在于更加能够应对代码迭代或修改的变化，是更高意义的面向接口编程
  * 6.object OOP是class OOP的伴生对象，class OOP能访问object OOP的一切内容，class OOP是 Object OOP的伴生类 object HelloOOP可以
  * 访问class OOP的一切内容，一个特例是private[this] 修饰的成员 ，后面学习
  * 7.在定义scala中的class中可以直接在类名中加入类构造参数，在apply中也必须加入参数
  * 8.scala apply中可以构造很多apply方法
  * 9.scala中很多集合都是通过apply构造的例如array
  **/
class OOP(age: Int) {
  var name = "spark"

  def sayHello = println("Hi my name is Scala " + name + " age:" + age)
}

object OOP {
  //可以通过内置一个number来构建一个索引
  var number = 0

  def main(args: Array[String]): Unit = {
    println("scala")
    //    val oop = new OOP
    val oop = OOP(30)
    oop.sayHello
    val oop2 = OOP()
    oop2.sayHello

  }

  //通过apply来控制对象生成
  def apply(age: Int): OOP = {
    println("my name is :" + number)
    number += 1
    new OOP(age)
  }

  //也可以通过空参构造来给予默认值
  def apply(): OOP = {
    println("my name is :" + number)
    number += 1
    new OOP(10)
  }

}


