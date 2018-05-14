package sandbox.functors

import scala.language.higherKinds

import cats._
import cats.implicits._

import cats.Functor

import org.scalatest.WordSpec

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]


object FunctorsSpecs {
  implicit val treeFunctor = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Branch(l, r) =>
        Branch(map(l)(f), map(r)(f))
      case Leaf(a) =>
        Leaf(f(a))
    }
  }
}


class FunctorsSpecs extends WordSpec {


  "Functions" should {
    "oo" in {

      import FunctorsSpecs._
      
      Branch(Leaf(10), Leaf(20)).map( _ * 2)

    }
  }


}
