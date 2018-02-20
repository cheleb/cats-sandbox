package json

import org.scalatest.WordSpec

case class Person(name: String, size: Int)

object JsonWriterInstances {
  implicit val stringWriter = new JsonWriter[String] {
    override def write(value: String): Json = JsString(value)
  }
  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      override def write(value: Person): Json = JsObject(
        Map("name" -> JsString(value.name),
          "size" -> JsNumber(value.size))
      )
    }
}

class JsonSpec extends WordSpec {

  "Person json writer" should {
    "write person as json through interface object" in {
      import JsonWriterInstances._
      Json.toJson(Person("Agnes", 160))
    }
  }

}
