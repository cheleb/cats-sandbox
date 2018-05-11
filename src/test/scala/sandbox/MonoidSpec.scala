package sandbox

import org.scalatest.{Matchers, WordSpec}
import cats.instances.string._
import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._
import cats.instances.map._

class MonoidSpec extends WordSpec with Matchers {
  "Monoid" should {
    "be fun" in {
      println("Cats" |+| " eat " |+| "a mouse")

      val some1: Option[Int] = Option(1)
      val some2: Option[Int] = Option(2)


      some1 |+| some2 shouldEqual Some(3)

      val map1 = Map("a" -> 1, "b" -> 2)
      val map2 = Map("b" -> 3, "d" -> 4)
      println(map1 |+| map2)
    }
  }
}