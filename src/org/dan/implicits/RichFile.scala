package org.dan.implicits

import java.io.File

import scala.io.Source

class RichFile(val from: File) {
  def read = Source.fromFile(from.getPath).mkString
}

object RichFile {
  implicit def file2RichFile(from: File) = new RichFile(from)
}
object MainApp {
  def main(args: Array[String]): Unit = {
    import RichFile._
    println(new File("/Users/ctbri/test.txt").read)
  }
}
