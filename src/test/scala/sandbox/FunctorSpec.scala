package sandbox

import org.scalatest.WordSpec

import cats.instances.function._
import cats.syntax.functor._

class FunctorSpec extends WordSpec {

  "cats" should {
    "love functor" in {
      val func1 = (a: Int) => a + 1
      val func2 = (a: Int) => a * 2
      val func3 = (a: Int) => a + "!"
      val func4 = func1.map(func2).map(func3)
      func4(123)
    }
  }

}
