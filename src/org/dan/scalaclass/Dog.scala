package org.dan.scalaclass

//scala类中，与类名相同的对象叫做伴生对象，
//类和伴生对象之间可以相互访问私有方法和属性
class Dog {
  val id = 1
  private var name = "itcast"

  def printName() : Unit = {
    //在Dog类中可以访问伴生对象Dog的私有属性
    println(Dog.CONSTANT + name)
  }
}

//伴生对象
object Dog {
  private val CONSTANT = "汪汪汪："

  def main(args: Array[String]): Unit = {
    val p = new Dog
    p.name = "123"
    p.printName()
  }
}

//apply方法
//通常会在类的伴生对象中定义apply方法，当遇到类名(参数1, ..., 参数n)时apply方法会被调用
object ApplyDemo {
  def main(args: Array[String]): Unit = {
    //调用了Array伴生对象的apply方法
    //def apply(x: Int, xs: Int*): Array[Int]
    //arr1中只有一个元素5
    val arr1 = Array(5)
    println(arr1.toBuffer)

    //new了一个长度为5的array，数组里面包含5个null
    var arr2 = new Array(5)
    println(arr2)
  }

}
