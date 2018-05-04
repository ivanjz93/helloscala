package org.dan.implicits

class MrRight[T <% Ordered[T]] {
  def choose(t1: T, t2: T) = {
    if(t1 > t2) t1 else t2
  }
}

class MrLeft[T : Ordering] {
  def choose(t1: T, t2: T): T = {
    val order = implicitly[Ordering[T]]
    if(order.gt(t1, t2)) t1 else t2
  }
}

class Boy(val name: String, var faceValue: Int) {

}

object ImplicitContext {
  implicit def boyToOrdered(b: Boy) = new Ordered[Boy] {
    override def compare(that: Boy): Int = {
      if(b.faceValue > that.faceValue) 1 else -1
    }
  }

  implicit object OrderingBoy extends Ordering[Boy] {
    override def compare(x: Boy, y: Boy): Int = {
      if(x.faceValue > y.faceValue) 1 else -1
    }
  }
}
object MainApp1 {

  def main(args: Array[String]): Unit = {
    import ImplicitContext._
    val boy1 = new Boy("boy1", 92)
    val boy2 = new Boy("boy2", 99)
    val mr = new MrRight[Boy]
    var result = mr.choose(boy1, boy2);
    println(result.name)
    val ml = new MrLeft[Boy]
    result = ml.choose(boy1, boy2)
    println(result.name)
  }
}
