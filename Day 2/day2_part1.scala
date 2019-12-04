import scala.io.Source
import scala.util.control.Breaks._

object Day2 {
    def runProgram(string: String): Int = {
        val numbers = string.split(",").map(_.toInt)
        var i: Int = 0

        numbers(1) = 12
        numbers(2) = 2

        breakable {
            while (i < numbers.size) {
                if (numbers(i) == 99)
                    break
                else if (numbers(i) == 1) {
                    numbers(numbers(i + 3)) = numbers(numbers(i + 1)) + numbers(numbers(i + 2))
                    i += 4
                }
                else if (numbers(i) == 2) {
                    numbers(numbers(i + 3)) =  numbers(numbers(i + 1)) * numbers(numbers(i + 2))
                    i += 4
                }
                else
                    i += 1
            }
        }

        numbers(0)
    }

    def main(args: Array[String]): Unit = {
        for (line <- Source.fromFile("input").getLines) {
           println(runProgram(line.trim))
        }
    }
}