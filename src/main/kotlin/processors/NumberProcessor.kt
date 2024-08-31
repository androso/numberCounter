package org.homework.processors

import org.homework.common.NumType
import org.homework.common.NumberEvaluationResult

data class NumberProcessorResult(
    val primesList: MutableList<Int>,
    val oddsList: MutableList<Int>,
    val evensList: MutableList<Int>
)

class NumberProcessor(private val limit: Int)  {
    fun processNumbers(): NumberProcessorResult {
        val primeNumbers = mutableListOf<Int>()
        val oddNumbers = mutableListOf<Int>()
        val evenNumbers = mutableListOf<Int>()

        for (i in 0..limit) {
            val result = evaluateNumber(i)
            if (result.numType == NumType.EVEN) {
                evenNumbers.add(i)
            } else if (result.numType == NumType.ODD) {
                oddNumbers.add(i)
            } else {
                primeNumbers.add(i)
            }
        }
        return NumberProcessorResult(primeNumbers, oddNumbers, evenNumbers)
    }

    private fun evaluateNumber(num: Int): NumberEvaluationResult {
        val numType: NumType
        var divisors = arrayOf(1, num)
        for (divider in 2..num) {
            if (num % divider == 0) {
                divisors += divider
            }
        }

        if (divisors.size == 2) {
            numType = NumType.PRIME
        } else if (num % 2 == 0) {
            numType = NumType.EVEN
        } else {
            numType = NumType.ODD
        }

        return NumberEvaluationResult(num, numType, divisors)
    }
}