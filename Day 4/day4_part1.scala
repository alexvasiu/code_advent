
object Day4 {
    def checkPassword(number: Int): Boolean = {
        val digits = number.toString.map(_.asDigit)

        if (!(digits.size == 6))
            return false

        var back: Int = -1
        var hasDouble: Boolean = false
        for (digit <- digits) {
            if (back == digit)
                hasDouble = true
            if (back > digit)
                return false
            back = digit
        }

        hasDouble
    }

    def main(args: Array[String]): Unit = {
       var count: Int = 0

       for (nr <- 246540 to 787419) {
           if (checkPassword(nr))
            count += 1
       }

       println(count)
    }
}