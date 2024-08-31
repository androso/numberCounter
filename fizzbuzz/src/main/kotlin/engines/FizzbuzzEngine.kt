package org.fizzbuzz.engines

interface FizzBuzzEngine {
    fun process(start: Int, end: Int): String
}

class FizzBuzz : FizzBuzzEngine {
    private fun evaluateNumber(number: Int): String {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz"
        } else if (number % 5 == 0) {
            return "Buzz"
        } else if (number % 3 == 0) {
            return "Fizz"
        } else {
            return number.toString()
        }
    }

    override fun process(start: Int, end: Int): String {
        if (end < start) {
            throw IllegalArgumentException("End value has to be equal or greater than starting value (1)")
        }
        var result = ""
        for (i in start..end) {
            result += "${evaluateNumber(i)}\n"
        }
        return result
    }
}