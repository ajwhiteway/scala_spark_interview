package example

import scala.io.StdIn.readLine


object AdditivePrimes {

//   def primeDigitSumPrimes(n: Int): List[Int]
//     // primeDigitSumPrimes(5) => List(2, 3, 5, 7, 23)
//     return

    def primeDigitSumPrimes(n: Int): List[Int] = {
    def isPrime(x: Int): Boolean =
        x > 1 && (2 to math.sqrt(x).toInt).forall(x % _ != 0)

    def digitSum(x: Int): Int =
        x.toString.map(_.asDigit).sum

    LazyList.from(2)
        .filter(isPrime)
        .filter(x => isPrime(digitSum(x)))
        .take(n)
        .toList
    }

    def main(args: Array[String]): Unit = {

        print("How many primes? ")
        val num = readLine()

        // Add your code here
        print(primeDigitSumPrimes(num.toInt))

        
    }
}
