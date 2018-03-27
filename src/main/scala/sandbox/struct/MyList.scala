package sandbox.struct

sealed trait MyList[+A] {

  def add(a: A)

}
