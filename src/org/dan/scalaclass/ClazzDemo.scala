package org.dan.scalaclass

/**
  * 超类的构造
  */
object ClazzDemo {
  def main(args: Array[String]): Unit = {
    val h = new Human
    println(h.fight())
  }
}

trait Flyable {
  def fly(): Unit = {
    println("I can fly")
  }
  def fight(): String
}

abstract class Animal {
  def run(): Int
  val name: String
}

class Human extends Animal with Flyable {
  val name = "abc"

  //打印几次"ABC"?
  val t1, t2, (a, b, c) = {
    println("ABC")
    (1,2,3)
  }

  println(a)
  println(t1._1)
  println(t1.hashCode())
  println(t2.hashCode())

  //在Scala中重写一个非抽象方法必须用override修饰
  override def fly(): Unit = {
    println("I can fly too")
  }

  //在子类中重写超类的抽象方法时，不需要使用override关键字，也可以写
  def run(): Int = {
    1
  }

  def fight(): String = {
    "fight with 棒子"
  }
}