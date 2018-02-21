package sandbox.printable

import org.scalatest.{Matchers, WordSpec}

class PrintableSpec extends WordSpec with Matchers {

  case class Cat(name: String, age: Int, color: String)

  implicit val catPrintable = new Printable[Cat] {
    override def format(value: Cat): String = {

      import PrintableInstances._

      val name = Printable.format(value.name)
      val age = Printable.format(value.age)
      val color = Printable.format(value.color)

      s"$name is a $age year $color cat."
    }
  }

  "Printable" should {

    val felix = Cat("felix", 2, "black/white")

    "format cat" in {
      Printable.format(felix) shouldEqual "felix is a 2 year black/white cat."
    }

    "print a cat" in {
      Printable.print(felix)
    }


    "format cat using syntax" in {
      import PrintableSyntax._
      felix.format shouldEqual "felix is a 2 year black/white cat."
    }

    "print a cat using syntax" in {
      import PrintableSyntax._
      felix.print
    }



  }

}
