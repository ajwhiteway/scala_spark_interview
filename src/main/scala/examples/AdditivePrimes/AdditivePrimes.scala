package example

import scala.io.StdIn.readLine


object AdditivePrimes {

//   def primeDigitSumPrimes(n: Int): List[Int]
//     // primeDigitSumPrimes(5) => List(2, 3, 5, 7, 23)
//     return

    def main(args: Array[String]): Unit = {

        print("How many primes? ")
        val num = readLine()

        // Add your code here
        print(primeDigitSumPrimes(num.toInt))

        
    }
}
