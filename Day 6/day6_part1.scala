import scala.io.Source
import scala.annotation.tailrec

object Day6 {
    case class Orbit(around: String, obj: String)

    def noOfRouts(list: List[Orbit], start: Orbit): Int = {
        for (a <- list) {
            if (a.obj == start.around)
                return 1 + noOfRouts(list, a)
        }
        
        1
    }

    def main(args: Array[String]): Unit = {
        val list: List[Orbit] = Source.fromFile("input").getLines.map(line => {
            val vals = line.split("\\)")
            Orbit(vals(0), vals(1))
        }).toList

        println(list.map(noOfRouts(list, _)).sum)
    }
}