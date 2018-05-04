package org.dan.scalaclass

//在Scala中，类不用声明为public
//一个Scala源文件中可以包含多个类，所有这些类都具有公有可见性
class Person {
  //用val修饰的变量是只读属性，有getter方法但没有setter方法
  val id = "9527"
  //用var修饰的变量既有getter又有setter
  var age: Int = 18
  //类私有字段只能在类和伴生对象的内部使用
  private var name: String = "唐伯虎"
  //对象私有字段，访问权限更加严格，只能在类的内部使用
  private[this] val pet = "小强"

}

object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person
    println(p.id)
    println(p.age)
    println(p.name)
    //println(p.pet)  error

    //p.id = "9528"   error
    p.age = 19
    p.name = "华安"

    println(p.id)
    println(p.age)
    println(p.name)
  }
}
