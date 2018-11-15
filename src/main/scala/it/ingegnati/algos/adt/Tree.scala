package it.ingegnati.algos.adt

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
  * Binary Tree ADT
  */
sealed trait Tree[+T]
case class Leaf[T](value: T) extends Tree[T]
case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]

object Tree {

  /**
    * This might be used to implement just about any recursive function that would
    * otherwise be defined by pattern matching!
    */
  def fold[T, U](tree: Tree[T])(f: T => U)(g: (U, U) => U): U = tree match {
    case Leaf(gamma) => f(gamma)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  /**
    * Using pattern matching it returns the size of the Tree
    * @param tree The Tree to compute the size of
    * @return the number of nodes of a Tree
    */
  def size[T](tree: Tree[T]): Int = tree match {
    case Leaf(_)      => 1 // A Leaf counts 1
    case Branch(l, r) => 1 + size(l) + size(r) // A Branch counts 1
  }

  /**
    * @param tree The tree to work on
    * @return the maximum path lenght from the root of a Tree to any leaf
    */
  def depth[T](tree: Tree[T]): Int = tree match {
    case Leaf(_) => 0
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  /**
    * @param tree The tree to work on
    * @param f The function to be applied to each leaf of the Tree
    * @tparam F The type of the element that will be returned by f
    * @return A new Tree which will be made by applying f to the original Tree
    */
  def map[T, F](tree: Tree[T], f: T => F): Tree[F] = tree match {
    case Leaf(x) => Leaf(f(x))
    case Branch(l, r) => Branch(map(l, f), map(r, f))
  }

  //  def maximum[T](): T = ???
}
