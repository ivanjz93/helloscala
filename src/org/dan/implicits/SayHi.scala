package org.dan.implicits

object Constant {
  implicit val name = "Scala"
}

class HelloWord {
  def sayHi(implicit name: String = "world"): Unit = {
    println(s"Hello $name")
  }
}

object HelloWord {
  def main(args: Array[String]): Unit = {
    val hw = new HelloWord
    hw.sayHi
    import Constant._
    hw.sayHi
  }
}
