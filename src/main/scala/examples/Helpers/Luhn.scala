
object Luhn {
  def check(number: String): Boolean = {
    val digits = number.filter(_.isDigit).map(_.asDigit)
    if (digits.isEmpty) return false

    val parity = (digits.length - 1) % 2

    val total = digits.zipWithIndex.map { case (d, i) =>
      if (i % 2 == parity) {
        val doubled = d * 2
        if (doubled > 9) doubled - 9 else doubled
      } else d
    }.sum

    total % 10 == 0
  }
}