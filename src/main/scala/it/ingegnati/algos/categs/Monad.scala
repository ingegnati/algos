package it.ingegnati.algos.categs

/**
  * A Monad is a parametric type (category) with two operations:
  * - flatMap
  * - unit (in Scala it will be defined as apply()
  */
trait Monad[T] {
  /**
    * In literature flatMap is more commonly called bind. You can think about
    * flatMap as a "glue" that can bind functions together.
    */
  def flatMap[U](f: T => Monad[U]): Monad[U]
}

class GenericMonad[T] private(value: T) extends Monad[T]{
  def flatMap[U](f: T => Monad[U]): Monad[U] = {
    val wrapped: Monad[U] = f(value)
    wrapped
  }
}

object GenericMonad {
  /**
    * This can be also called "unit' or "bind" or "zero"
    */
  def apply[T](x: T): Monad[T] = new GenericMonad[T](x)
}
