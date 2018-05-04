package org.dan

import scala.util.Random

//匹配字符串
object CaseDemo01 {
  def main(args: Array[String]): Unit = {
    val arr = Array("YshizawaAkiho", "Yuihatano", "AoiSola")
    val name = arr(Random.nextInt(arr.length))
    println(name)
    name match {
      case "YshizawaAkiho" => println("老师1")
      case "Yuihatano" => println("老师2")
      case _ => println("unknown")
    }
  }
}

//匹配类型
object CaseDemo02 {
  def main(args: Array[String]): Unit = {
    val arr = Array("hello", 1, 2.0, CaseDemo02)
    val v = arr(Random.nextInt(arr.length))
    println(v)
    v match {
      case x: Int => println("Int " + x)
      //匹配的时候还可以添加守卫条件，如不符合守卫条件，将掉入case _ 中
      case y: Double if(y >= 0) => println("Double " + y)
      case z: String => println("String " + z)
      case _ => throw new Exception("not match exception")
    }
  }
}

//匹配数组、元组
object CaseDemo03 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5)
    arr match {
      case Array(1, x, y) => println(x + " " + y);
      case Array(0) => println("only 0")
      case Array(0, _*) => println("0 ...")
      case _ => println("something else")
    }

    val lst = List(3, -1)
    lst match {
      case 0 :: Nil => println("only 0")
      case x :: y :: Nil => println(s"x: $x y: $y")
      case 0 :: tail => println("0 ...")
      case _ => println("something else")
    }

    val tup = (2, 3, 7)
    tup match {
      case (1, x, y) => println(s"1, $x, $y")
      case (_, z, 5) => println(z)
      case _ => println("else")
    }
  }
}

//样例类
//Scala中样例类是一种特殊的类，可用于模式匹配。
//case class是多例的，后面要跟构造参数，case object是单例的
case class SubmitTask(id:String, name: String)
case class HeartBeat(time: Long)
case object CheckTimeOutTask

object CaseDemo04 {
  def main(args: Array[String]): Unit = {
    val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))

    arr(Random.nextInt(arr.length)) match {
      case SubmitTask(id, name) => {
        println(s"$id, $name")
      }
      case HeartBeat(time) => {
        println(time)
      }
      case CheckTimeOutTask => {
        println("check")
      }
    }
  }
}

//Option类型
//Scala中Option类型样例类用来表示可能存在也可能不存在的值
//Option的子类有Some和None。Some包装了某个值，None表示没有值
object OptionDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("a" -> 1, "b" -> 2)
    val v = map.get("b") match {
      case Some(i) => i
      case None => 0
    }
    println(v)

    //更好的方式
    val v1 = map.getOrElse("C", 0)
    println(v1)
  }
}

//偏函数
//被包在花括号内没有match的一组case语句是一个偏函数，
//它是PartialFunction[A,B]的一个实例，
//A代表参数类型，B代表返回类型，常用作输入模式匹配
object PartialFuncDemo {
  def func1 : PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  def func2(num: String) : Int = num match {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  def main(args: Array[String]): Unit = {
    println(func1("one"))
    println(func2("one"))
  }
}
