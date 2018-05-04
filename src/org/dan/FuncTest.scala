package org.dan

object FuncTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    println(arr.toBuffer)
    //定义一个函数并将函数赋值给变量fun1
    val fun1 = (x: Int) => x * 2
    //将函数作为参数传入map方法中
    println(arr.map(fun1).toBuffer)
    //直接将匿名函数传入到map方法中
    println(arr.map((x: Int) => x * 2).toBuffer)
    //Scala可以自动推断参数类型，可以更精简
    println(arr.map(x => x * 2).toBuffer)
    //使用下划线，最精简的模式
    println(arr.map(_ * 2).toBuffer)

    //使用下划线，将方法转换为函数
    def m(x: Int) = x * 3
    val fun2 = m _
    println(arr.map(fun2).toBuffer)

    //柯里化
    //指将原来接收两个参数的方法变成新的接收一个参数的方法的过程


    //一个比较奇怪的写法，看起来即像方法又像函数
    def m1(x: Int) = (y: Int) => x * y
    //将一个参数3传进方法后，彻底变成了一个函数
    val fun3 = m1(3)
    println(fun3)

    //然后再调用这个函数并传入第二个参数，得到最终结果
    println(fun3(5))

    //柯里化常见的写法
    def m2 (x: Int)(y: Int) = x * y
    val fun4 = m2(3)(_)
    println(fun4(2))
  }

}
