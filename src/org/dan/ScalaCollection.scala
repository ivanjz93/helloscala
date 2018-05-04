package org.dan

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object ScalaCollection {
  def main(args: Array[String]): Unit = {
    //------------------数组-------------------------
    //初始化一个长度为8的定长数组，所有元素都为0
    val arr1 = new Array[Int](8)
    //直接打印定长数组，内容为数组的hashcode值
    println(arr1)
    //将数组转换成数组缓冲，就可以打印出数组内容
    //toBuffer会将数组转换为变长的数组缓冲
    println(arr1.toBuffer)

    //如果没有new，相当于调用了数组的apply方法，直接为数组赋值
    //初始化一个长度为1，内容为10的定长数组
    val arr2 = Array[Int](10)
    println(arr2.toBuffer)

    //使用()来访问元素
    val arr3 = Array("hadoop", "storm", "spark")
    println(arr3(2))

    //变长数组（数组缓冲）
    //需要导入scala.collection.mutable.ArrayBuffer
    val ab = ArrayBuffer[Int]()
    //尾部追加元素
    ab += 1
    //追加多个元素
    ab += (2,3,4,5)
    //追加数组使用++=，注意上一行追加的是一个元素
    ab ++= Array(6, 7)
    //追加一个数组缓冲
    ab ++= ArrayBuffer(8, 9)
    println(ab)

    //在数组某个位置插入元素
    ab.insert(0, -1, 0)
    //删除数组某个位置的元素
    ab.remove(8, 2)
    println(ab)

    //遍历数组，使用until生成角标
    for(i <- (0 until arr3.length).reverse)
      println(arr3(i))

    //数组转换，可使用map函数替代yield
    val arr4 = Array(1,2,3,4,5,6,7,8,9)
    val r = arr4.filter(_ % 2 == 0).map(_ * 10)
    println(r.toBuffer)

    //数组常用函数
    println(arr4.sum)
    println(arr4.max)
    println(arr4.sorted)

    //------------------映射-------------------------
    //创建映射使用->和元组
    val scores = Map("tom" -> 85, "jerry" -> 99, "kitty" -> 90);
    println(scores)
    val scores1 = Map(("tom", 85), ("jerry", 99), ("kitty", 90));
    println(scores1)

    //获取映射的值
    println(scores("jerry"))
    println(scores.getOrElse("suke", 0))

    //可变数组
    val scores2 = scala.collection.mutable.Map(("tom", 85), ("jerry", 99));
    scores2("tom") = 88
    println(scores2)
    scores2 += (("kitty", 90), ("suke", 60))
    scores2.put("beta", 88)
    println(scores2)
    scores2 -= "kitty"
    scores2.remove("suke")
    println(scores2)

    //------------------元组-------------------------
    //元素可以任意多个，元素的类型可以不一样
    val t = ("hadoop", 3.14, 65535)
    println(t)
    //获取元组数据，元组下表从1开始
    val t1, (a,b,c) = ("hadoop", 3.14, 65535)
    println(t1)
    println(a)
    println(b)
    println(c)
    println(t1._1)
    //将对偶元组转换为映射
    val arr5 = Array(("tom", 88), ("jerry", 95))
    println(arr5.toMap)
    //zip将对应的值绑定在一起
    val ns = Array("tom", "jerry", "kitty")
    val ss = Array(88, 95, 80)
    println(ns.zip(ss))
    println(ns.zip(ss).toBuffer)
    println(ns.zip(ss).toMap)

    //------------------序列-------------------------
    val lst1 = List(1,2,3)
    //在列表前面添加元素
    val lst2 = 0 :: lst1
    val lst3 = lst1.::(0)
    val lst4 = 0 +: lst1
    var lst5 = lst1.+:(0)
    println(lst1)
    println(lst2)
    println(lst3)
    println(lst4)
    println(lst5)
    //在列表后面追加元素
    val lst6 = lst1 :+ 3
    val lst0 = List(4,5,6)
    println(lst1 ++ lst0)
    println(lst1 ++: lst0)
    //将lst0插入到lst1前面
    println(lst1.:::(lst0))
    println(lst0 ::: lst1)

    //可变序列scala.collection.mutable.ListBuffer
    val lb = ListBuffer[Int](1,2,3)
    val lb1 = new ListBuffer[Int]
    lb1 += 4
    lb1.append(5)
    println(lb1)
    lb ++= lst1
    println(lb)

    //------------------集合-------------------------
    //集合中的元素不能重复
    val set1 = new mutable.HashSet[Int]()
    println(set1 + 4)
    println(set1 ++ Set(5, 6, 7))
    val set0 = Set(1,3,4) ++ set1
    println(set0)
    println(set0.getClass)

    //可变集合
    val mset1 = new mutable.HashSet[Int]()
    mset1 += 2
    mset1.add(4)
    mset1 ++= Set(1,3,5)
    println(mset1)
    mset1 -= 5
    mset1.remove(2)
    println(mset1)
  }
}
