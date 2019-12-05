import scala.io.Source
import scala.util.control.Breaks._
import scala.io.StdIn._

object Day5 {
    def getNumber(numbers: Array[Int], position: Int, mode: Int): Int = {
        mode match {
            case 0 => numbers(position)
            case 1 => position
            case _ => -1 // NEVER HERE
        }
    }

    def runProgram(string: String): Unit = {
        var numbers = string.split(",").map(_.toInt)
        var i: Int = 0

        breakable {
            while (i < numbers.size) {
                val a: Int = numbers(i) /  10000
                val b: Int = numbers(i) / 1000 % 10
                val c: Int = numbers(i) / 100 % 10
                val op: Int = numbers(i) % 100

                op match {
                    case 99 => break
                    case 1 => 
                        numbers(getNumber(numbers, i + 3, a)) = numbers(getNumber(numbers, i + 1, c)) + numbers(getNumber(numbers, i + 2, b))
                        i += 4
                    case 2 =>
                        numbers(getNumber(numbers, i + 3, a)) = numbers(getNumber(numbers, i + 1, c)) * numbers(getNumber(numbers, i + 2, b))
                        i += 4
                    case 3 =>
                        numbers(numbers(i + 1)) = 1
                        i += 2
                    case 4 =>
                        println(numbers(numbers(i + 1)))
                        i += 2
                    case _ => 
                        i += 1 // NEVER HERE

                }
            }
        }
    }

    def main(args: Array[String]): Unit = {
        for (line <- Source.fromFile("input").getLines) {
           runProgram(line.trim)
        }
    }
}