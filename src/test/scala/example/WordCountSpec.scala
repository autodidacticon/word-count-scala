package example

import org.scalatest._

import scala.collection.mutable.Map

class WordCountSpec extends FlatSpec with Matchers {

  trait WordCountUtilSpec {
    val words = Iterator("one", "two", "three")
    val util = new WordCountUtil[String] {
      //you can provide override implementations here for testing purposes, but the implementations in WordCount.scala are primary
    }

    def passed: Assertion
  }
  "WordCountUtil.map" should "return a list of tuples" in {
    new WordCountUtilSpec {
      def passed = {
        words.map(util.mapper).toSeq shouldEqual Seq("one" -> 1, "two" -> 1, "three" -> 1)
      }
    }.passed
  }

  "WordCountUtil.reducer" should "return a map of tuples" in {
    new WordCountUtilSpec {
      def passed = {
        words.map(util.mapper).foldLeft(Map.empty[String, Int])(util.reducer) shouldEqual Map("one" -> 1, "two" -> 1, "three" -> 1)
      }
    }.passed
  }
}
