package org.dan

object ScalaBasic {
  def main(args: Array[String]) {
    println("hell scala")

    //------------------声明变量-------------------------
    //使用val定义的变量值是不可变的，相当于java的fianl
    val i = 1
    //使用var定义的变量是可变的，在Scala中鼓励使用val
    var s = "hello"
    //Scala编译器回自动推断变量的类型，必要的时候可以指定类型
    //变量名在前，类型在后
    val str: String = "world"

    //------------------条件表达式-------------------------
    val x = 1
    val y = if(x > 0) 1 else -1
    println(y)
    //支持混合类型表达式
    val z = if(x>1) 1 else "error"
    println(z)
    //如果没有else，相当于if(x>2) 1 else ()
    val m = if(x>2) 1
    println(m)
    //在scala中每个表达式都有值，scala中有个Unit类，写做()，相当于Java中的void
    val n = if(x>2) 1 else ()
    println(n)
    //if 和 else if
    val k = if(x < 0) 0 else if (x >= 1) 1 else -1
    println(k)

    //------------------块表达式-------------------------
    //scala中{}中可包含一系列表达式，块中最后一个表达式的值就是块的值
    val result = {
      if(x < 0) {
        -1
      } else if(x >= 1) {
        1
      } else {
        "error"
      }
    }
    println(result)

    //------------------循环-------------------------
    // 有for循环和while循环，for循环用的多
    // for (i <- 表达式/数组/集合)

    //表达式 1 to 10返回一个Range（区间）
    for(i <- 1 to 10)
      println(i)
    //循环数组
    var arr = Array("a", "b", "c")
    for(i <- arr)
      println(i)
    //每个生成器都可以带一个条件
    for(i <- 1 to 3; j <- 1 to 3 if i != j)
      print((10*i + j) + " ")
    println()
    //for推导式：如果for循环体以yield开始，则该循环会构建出一个集合
    var v = for(i <- 1 to 10) yield i * 10
    println(v)

    //------------------定义方法-------------------------
    def m1(x: Int, y: Int): Int = x * y
    println(m1(2,3))

    //------------------定义函数-------------------------
    val f1 = (x: Int, y: Int) => x + y
    println(f1(2, 3))

    //------------------将函数作为参数传入方法-------------------------
    def m2(f: (Int, Int) => Int) = f(2, 6)
    val f2 = (x: Int, y: Int) => x - y
    val f3 = (m: Int, n: Int) => m * n
    println(m2(f2))
    println(m2(f3))

    //------------------将方法转换为函数-------------------------
    def m3(i: Int, j: Int): Int = i / j
    println(m2(m3 _))
  }

}
