import scala.io.Source
import scala.annotation.tailrec

object Day6 {
    case class Orbit(around: String, obj: String)

    def routs(list: List[Orbit], start: Orbit): List[Orbit] = {
        for (a <- list) {
            if (a.obj == start.around)
                return a :: routs(list, a)
        }
        
        List()
    }

    def main(args: Array[String]): Unit = {
        val list: List[Orbit] = Source.fromFile("input").getLines.map(line => {
            val vals = line.split("\\)")
            Orbit(vals(0), vals(1))
        }).toList


        val youOrbit = list.filter(x => x.obj == "YOU")(0)
        val sanOrbit = list.filter(x => x.obj == "SAN")(0)

        val routsYou = routs(list, youOrbit)
        val routsSan = routs(list, sanOrbit)

        val intersectionNode = (routsSan intersect routsYou)(0)

        println(routsYou.indexOf(intersectionNode) + routsSan.indexOf(intersectionNode))
    }
}