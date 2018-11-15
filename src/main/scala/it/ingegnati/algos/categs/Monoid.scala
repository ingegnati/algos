package it.ingegnati.algos.categs

/**
  * The monoid is a category with one object
  */
trait Monoid[T] {
  /**
    * ASSOCIATIVE binary operation, op, that takes two values of type T and combines
    * them into one: op(op(x,y), z) == op(x, op(y,z)) for any choice of
    * - x: T
    * - y: T
    * - z: T
    */
  def op(x: T, y: T): T

  /**
    * A value, zero: T, that is an identity for that operation:
    * - op(x, zero) == x and
    * - op(zero, x) == x
    *
    * for any x: T
    */
  def zero: T
}
