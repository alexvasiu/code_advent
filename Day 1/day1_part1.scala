import scala.io.Source

object Day1 {
    def calcFuel(mass : Int): Int = {
        mass / 3 - 2
    }

    def main(args: Array[String]): Unit = {
        var sum: Int = 0

        for (line <- Source.fromFile("input").getLines) {
            sum += calcFuel(line.trim.toInt)
        }

        println(sum)
    }
}