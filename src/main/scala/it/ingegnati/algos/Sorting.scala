package it.ingegnati.algos

/*
 * Algos - Scala Algorhitms and Data structures
 * Copyright (C) 2018 sentenza, ingegnati.it
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
  * Definitions of the common sorting algorithms.
  *
  * @tparam F A set of iterable elements (Array or Iterable)
  * @tparam T The type of the elements contained in the set
  */
sealed trait Sorting[F[_], T] {

  /* ****** Insertion Sorts ****** */

  /** Insertion Sort
    * [[https://en.wikipedia.org/wiki/Insertion_sort Wikipedia: Insertion Sort]]
    */
  def isort(xs: F[T]): F[T]

  /* ****** Merge Sorts ****** */

  /** Merge Sort
    * [[https://en.wikipedia.org/wiki/Merge_sort Wikipedia: Merge Sort]]
    */
  def msort(xs: F[T]): F[T]

  /* ****** Exchange Sorts ****** */

  /** Bubble Sort
    * [[http://en.wikipedia.org/wiki/Bubble_sort Wikipedia: Bubble Sort]]
    */
  def bubbleSort(xs: F[T]): F[T]

  /** Comb Sort
    * [[https://en.wikipedia.org/wiki/Comb_sort Wikipedia: Comb Sort]]
    */
  def combSort(xs: F[T]): F[T]

  /** Quick Sort
    * [[https://en.wikipedia.org/wiki/Quicksort Wikipedia: Quick Sort]]
    */
  def qsort(xs: F[T]): F[T]

  /* ****** Selection Sorts ****** */

  /** Selection Sort
    * [[https://en.wikipedia.org/wiki/Selection_sort Wikipedia: Selection Sort]]
    */
  def selectionSort(xs: F[T]): F[T]

  /** Heap Sort
    * [[https://en.wikipedia.org/wiki/Heapsort Wikipedia: Heap Sort]]
    */
  def heapSort(xs: F[T]): F[T]

  /* ****** Distribution Sorts ****** */

  /** Bucket Sort
    *
    */
  def bucketSort(xs: F[T], n: Int, sort: F[T] => F[T]): F[T]

  /** Count Sort
    *
    */
  def countSort(xs: F[T]): F[T]

  /** Radix Sort
    *
    */
  def radixSort(xs: F[T], base: Int): F[T]
}

object ListSorting extends Sorting[List, Int] {

  /** @inheritdoc
    * We have to sort the list picking its first element and inserting it in the right
    * place of its iSorted tail.
    */
  override def isort(xs: List[Int]): List[Int] = {

    def insert(ele: Int, ys: List[Int]): List[Int] = ys match {
      case Nil => List(ele)
      case y :: ysl => if (ele <= y) ele :: ys
                      else y :: insert(ele, ysl)
    }

    xs match {
      case Nil => Nil
      case x :: xsl => insert(x, isort(xsl))
    }
  }

  /** Merge Sort
    * [[https://en.wikipedia.org/wiki/Merge_sort Wikipedia: Merge Sort]]
    */
  override def msort(xs: List[Int]): List[Int] = ???

  /** Bubble Sort
    * [[http://en.wikipedia.org/wiki/Bubble_sort Wikipedia: Bubble Sort]]
    */
  override def bubbleSort(xs: List[Int]): List[Int] = ???

  /** Comb Sort
    * [[https://en.wikipedia.org/wiki/Comb_sort Wikipedia: Comb Sort]]
    */
  override def combSort(xs: List[Int]): List[Int] = ???

  /** Quick Sort
    * [[https://en.wikipedia.org/wiki/Quicksort Wikipedia: Quick Sort]]
    */
  override def qsort(xs: List[Int]): List[Int] = ???

  /** Selection Sort
    * [[https://en.wikipedia.org/wiki/Selection_sort Wikipedia: Selection Sort]]
    */
  override def selectionSort(xs: List[Int]): List[Int] = ???

  /** Heap Sort
    * [[https://en.wikipedia.org/wiki/Heapsort Wikipedia: Heap Sort]]
    */
  override def heapSort(xs: List[Int]): List[Int] = ???

  /** Bucket Sort
    *
    */
  override def bucketSort(xs: List[Int], n: Int, sort: List[Int] => List[Int]): List[Int] = ???

  /** Count Sort
    *
    */
  override def countSort(xs: List[Int]): List[Int] = ???

  /** Radix Sort
    *
    */
  override def radixSort(xs: List[Int], base: Int): List[Int] = ???
}
