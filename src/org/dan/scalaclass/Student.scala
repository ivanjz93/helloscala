package org.dan.scalaclass

import java.io.IOException


//每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
class Student(val name: String, val age: Int) {
  //主构造器会执行类定义中的所有语句
  println("执行主构造器")
  try {
    println("读取文件")
    throw new IOException("io exception")
  } catch {
    case e : NullPointerException => println(e)
    case e : IOException => println(e)
  } finally {
    println("执行finally部分")
  }

  private var gender = "male"

  //用this关键字定义辅助构造器
  def this(name: String, age: Int, gender: String) {
    //每个辅助构造器必须以主构造器或者其它的辅助构造器的调用开始
    this(name, age)
    println("执行辅助构造器")
    this.gender = gender
  }
}
object Student {
  def main(args: Array[String]): Unit = {
    val s1 = new Student("test1", 18)
    val s2 = new Student("test2", 19, "female")
  }
}

//构造器参数可以不带val或var，如果不带val或var的参数至少被一个方法所使用
//那么它将会被提升为字段
//在类名后面加private就变成了私有的
class Queen private (val name: String, prop: Array[String], private var age: Int = 18){
  println(prop.size)
  //prop被下面的方法使用后，prop就变成了不可变的对象私有字段，等同于private[this] val prop
  //如果没有被方法使用该参数不被保存为字段，仅仅是一个可以被主构造器中的代码访问的普通参数
  def description = name + "is" + age + " years old with " + prop.toBuffer
}

object Queen {
  def main(args: Array[String]): Unit = {
    val q = new Queen(("queen1"), Array("prop1", "prop2"), 20)
    println(q.description)
  }
}
