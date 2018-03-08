package example

import java.io.{File, PrintWriter}

object GenNumbers extends App {

  val writer = new PrintWriter(new File("numbers.txt"))
  (0 until 1000).foreach(n => writer.write((n % 13).toString + "\n"))
  writer.close()

}
