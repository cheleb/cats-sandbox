package sandbox.printable

import org.scalatest.{Matchers, WordSpec}

class PrintableSpec extends WordSpec with Matchers {

  case class Cat(name: String, age: Int, color: String)

  val felix = Cat("felix", 2, "black/white")

  "Printable" should {

    implicit val catPrintable = new Printable[Cat] {
      override def format(value: Cat): String = {

        import PrintableInstances._

        val name = Printable.format(value.name)
        val age = Printable.format(value.age)
        val color = Printable.format(value.color)

        s"$name is a $age year $color cat."
      }
    }

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

  "Cat printable" should {

    import cats._
    import cats.instances.string._
    import cats.instances.int._
    import cats.syntax.show._


    "format cat" in {
      implicit val catShower = Show.show[Cat] {
        cat =>
          val name = cat.name.show
          val age = cat.age.show
          val color = cat.color.show

          s"$name is a $age year $color cat."
      }
      felix.show shouldEqual "felix is a 2 year black/white cat."
    }
  }

}