import scala.io.Source
import scala.math._

object Day3 {
    case class Point(x: Int, y: Int)

    def distance(point1: Point, point2: Point): Int = {
        abs(point1.x - point2.x) + abs(point1.y - point2.y)
    }

    def getPath(commands: String): List[Point] = {
        var list = List[Point]()
        val cmds = commands.split(",")
        var currPoint = Point(1, 1)
        
        for (cmd <- cmds) {
            val direction = cmd(0)
            var steps = cmd.substring(1).toInt

            for (i <- 0 until steps) {
                direction match {
                    case 'R' => currPoint = Point(currPoint.x + 1, currPoint.y)
                    case 'L' => currPoint = Point(currPoint.x - 1, currPoint.y)
                    case 'U' => currPoint = Point(currPoint.x, currPoint.y + 1)
                    case 'D' => currPoint = Point(currPoint.x, currPoint.y - 1)
                    case _ =>
                }

                list = currPoint :: list
            }           
        }

        list
    }

    def main(args: Array[String]): Unit = {

        val lines = Source.fromFile("input").getLines()
        val firstPath = getPath(lines.next())
        val secondPath = getPath(lines.next())

        val intersectionPoints = firstPath.intersect(secondPath)

        println(intersectionPoints.map(point => firstPath.size - firstPath.indexOf(point) + secondPath.size - secondPath.indexOf(point)).min)
    }
}