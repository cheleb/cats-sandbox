package sandbox.monoid



import org.scalatest.{Matchers, WordSpec}
import SetMonoids._

class MonoidSpec extends WordSpec with Matchers {

  "Set Monoid" should {
    "be resolver"  in {


      val momo = union[Int]

      momo.combine(Set(1), Set(2)) shouldEqual Set(1,2)


    }


  }

}
