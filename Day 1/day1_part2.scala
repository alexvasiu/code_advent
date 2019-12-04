import scala.io.Source

object Day1 {
    def calcFuel(mass : Int): Int = {
        var fuelSum: Int = 0
        var fuel: Int = mass / 3 - 2

        while (fuel > 0) {
            fuelSum += fuel
            fuel = fuel / 3 - 2
        }

        fuelSum
    }

    def main(args: Array[String]): Unit = {
        var sum: Int = 0

        for (line <- Source.fromFile("input").getLines) {
            sum += calcFuel(line.trim.toInt)
        }

        println(sum)
    }
}