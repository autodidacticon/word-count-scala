package example

import scala.collection.mutable.Map
import scala.io.Source

object WordCount extends WordCountUtil[String] with App {

  //you don't need to alter this method here (unless you really want to ;)
  def getWordStream: Iterator[String] = Source.fromFile(getClass().getResource("/words.txt").getPath).getLines()

  //print out a list of distinct words and the number of their occurrences
}


//fix these implementations
trait WordCountUtil[String] extends AbstractWordCountUtil[String] {
  override def mapper(word: String) = word -> 0

  override def reducer(wordMap: Map[String, Int], wordTuple: (String, Int)) = Map.empty[String, Int]
}

//abstract definitions
trait AbstractWordCountUtil[T] {

  def mapper(word: T): (T, Int)

  def reducer(wordMap: Map[T, Int], wordTuple: (T, Int)): Map[T, Int]
}
