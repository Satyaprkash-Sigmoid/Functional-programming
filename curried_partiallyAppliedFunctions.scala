object curried_partiallyAppliedFunctions extends App {

  //Curried Function
   def superAdder:Int=>Int=>Int
     =x=>y=>x+y

   val add3 = superAdder(3)
   println(add3(5))
   println(superAdder(3)(5))

  //curried Method
  def curriedMethod(x:Int)(y:Int):Int=x+y


  // transforming a method to function is called - lifting
  val add4: Int=>Int = curriedMethod(4)
  // More Technical term of lifting is ETA-Expansion
  // function != method (due to JVM Limitation)
  // We can not use methods in HigherOrder Function unless they transformed into functional values
  // Method are part of instances of classes


  // Partial Function Application
  val add5 = curriedMethod(5) _ // Putting _ here tells compiler to do an ETA-Expansion on curriedMethod after applied first parameter
  println(add5(5))

  // ETA-EXPANSION - does by compiler
  def inc(x:Int):Int=x+1

  List(1,2,3).map(inc).foreach(println)
  //  List(1,2,3).map(x=>inc(x))  // but Behind the scene Eta-Expansion done by the compiler


//  Exercise - 1
  val simpleAddition = (x:Int,y:Int) => x+y
  def simpleAddMethod(x:Int,y:Int) = x+y
  def curriedAddMethod(x:Int)(y:Int)=x+y

//  Task - create all possible add7 using above
  val add7_1 = curriedMethod(7) _ // first implementation using curried
  val add7_5 = curriedMethod(7)(_) // PAF this wee can use for non curried methods
//  val add7_2 = curriedMethod (7)
  val add7_3 = (x:Int) => simpleAddition(7,x)
  val add7_4 = simpleAddition.curried(7)
  val add7_6 = simpleAddMethod(7,_:Int)
  val add7_7 = simpleAddition(7,_:Int)


  // Underscores are powerful
  def concatenator(x:String,y:String,z:String) = x+y+z
  val insertName = concatenator("Hello My name is ", _:String , " I am from Panipat")
  println(insertName("Kapil"))

  val fillInBlanks = concatenator("Heloo", _:String,_:String)
  println(fillInBlanks("kapil", "What are you doing"))


//  Exercise - 2
  /**Process a list of numbers and return their string representation with different formatter
   * Use the %4.2f, %8.6f, %14.12f
   */

  def curriedFormattor(s:String)(d:Double):String = s.format(d)
  val numbers = List(Math.PI,Math.E,1,9.8,1.3e-12)

  val simpleFormat = curriedFormattor("%4.2f") _
  val tightFormat = curriedFormattor("%8.6f") _
  val preciseFormat = curriedFormattor("%14.12f") _

  println(numbers.map(simpleFormat))
  println(numbers.map(tightFormat))
  println(numbers.map(preciseFormat))


}
