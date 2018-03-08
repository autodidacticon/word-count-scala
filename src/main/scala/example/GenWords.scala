package example
import java.io.{File, PrintWriter}
object GenWords extends App {

  val words = Seq("foo", "bar", "baz", "qux", "quux", "corge", "uier", "grault", "garply", "waldo", "fred", "plugh", "thud", "mos", "henk", "def")

  val writer = new PrintWriter(new File("words.txt"))
  (0 until 1000).foreach(n => writer.write(words(n % words.length) + "\n"))
  writer.close()
}
