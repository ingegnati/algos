package it.ingegnati.algos

import org.scalatest.{Matchers, WordSpec}
import scala.util.Random

class ListSortingSpec extends WordSpec with Matchers {

  private val defaultLength = Math.max(100, (new Random).nextInt(1000))

  /**
    * Returns a list of random numbers
    *
    * @param length The length of the list to be built
    * @return A List of random integers
    */
  def randList(length: Int = defaultLength): List[Int] = {
    List.fill(length)((new Random).nextInt(length))
  }

  /**
    * creates a random array and applies the algorithm,
    * comparing the result with a sorted version
    */
  private def checkSortingWith(alg: List[Int] => List[Int]) = {
    val xs = randList()
    alg(xs) shouldBe xs.sorted
  }

  "ListSorting" should {
    "sort a List[Int] using Insertion Sort" in {
      checkSortingWith(ListSorting.isort)
    }
  }

}
