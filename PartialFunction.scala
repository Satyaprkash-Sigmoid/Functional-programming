object PartialFunction extends App {

//  Partial Function -> It is a function which accept only few elements from Int
//  Partial Functions work on the basis of match
//  A partial function can only have one parameter Type

    def part_Function : PartialFunction[Int,Int]={
      case 1 => 34
      case 2 => 67
      case 5 => 999
    }

   println(part_Function(5))

//  Some utilities of partial Functions
//1. isDefinedAt - Check Weather the partial function is defined at a particular value.

   println(part_Function.isDefinedAt(89))

  //  2. lift - this transforms Int => (option(Int))
  val lifted = part_Function.lift
  println(lifted(2))  //print- 67 value defined at 2
  println(lifted(98)) //print- None

//  3. Partial Function Chain
  val partFun_Chain = part_Function.orElse[Int,Int]{
    case 4 => 234
  }
   println(partFun_Chain(2))
   println(partFun_Chain(4))

  // Partial function extend normal function
  // Higher Ordered Functions Accepts Partial Functions as well

//  Assignment - 1 -> Create a Partial Function instance yourself(anonymous class)

  val part_function_instance = new PartialFunction[Int,Int]{
    override def apply(v1: Int): Int = v1 match{
      case 1 => 12
      case 2 => 23
      case 5 => 56
    }

    override def isDefinedAt(x: Int): Boolean =
      x==1 || x==2 || x==5
  }


//  Assginment 2 - create a chatbot

  def chatbot : PartialFunction[String,String]={
    case "hello" => "Hi may name is kapil kumar"
    case "byee"  => "Nice to mee you"
    case "greet" => "You are welcome"
  }

//  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
  scala.io.Source.stdin.getLines().foreach(line => println("chatbot says - "+chatbot(line)))
}
