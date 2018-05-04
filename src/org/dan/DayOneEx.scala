package org.dan

object DayOneEx {
  def main(args: Array[String]): Unit = {
    val lst0 = List(1,7,9,8,0,3,5,4,6,2)
    println(lst0.map(_*10))
    println(lst0.filter(_ % 2 == 0))
    println(lst0.sorted)
    println(lst0.sorted.reverse)
    println(lst0.grouped(4))
    println(lst0.grouped(4).toList)
    println(lst0.grouped(4).toList.flatten)

    //单机版wordcount
    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    println(lines.map(_.split(" ")).flatten.map(_ -> 1).groupBy(_._1).mapValues(_.size).toList.sortBy(_._2).reverse)
    println(lines.map(_.split(" ")).flatten.map(_ -> 1).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2)).toList.sortBy(_._2).reverse)

    println(lst0.par.sum)
    println(lst0.par.reduce((x,y) => {x+y}))
    println(lst0.par.reduce(_ + _))
    println(lst0.par.reduceLeft(_+_))
    println(lst0.fold(10)(_+_))
    println(lst0.par.fold(10)(_+_))
    println(lst0.foldLeft(0)(_-_))
    println(lst0.par.foldLeft(0)(_-_))


    val l1 = List(5,6,4,7)
    val l2 = List(1,2,3,4)
    //并集
    println((l1.toSet ++ l2.toSet).toList)
    println(l1.union(l2))
    //交集
    println((l1.toSet & l2.toSet).toList)
    println(l1.intersect(l2))
    //差集
    println((l1.toSet -- l2.toSet).toList)
    println(l1.diff(l2))

    val arr = List(List(1,2,3), List(3,4,5),List(2),List(0))
    println(arr.aggregate(0)(_+_.sum, _+_))//20
    println(arr.aggregate(10)(_+_.sum, _+_))//30
    println(arr.par.aggregate(10)(_+_.sum, _+_))//60



  }

}
