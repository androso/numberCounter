package org.homework.processors

import org.homework.common.NumType
import org.homework.common.NumberEvaluationResult

data class NumberProcessorResult(
    val primesList: MutableList<Int>,
    val oddsList: MutableList<Int>,
    val evensList: MutableList<Int>
)

class NumberProcessor() {
    fun processNumbers(limit: Int): NumberProcessorResult {
        val primeNumbers = mutableListOf<Int>()
        val oddNumbers = mutableListOf<Int>()
        val evenNumbers = mutableListOf<Int>()

        for (i in 1..limit) {
            val result = evaluateNumber(i)
            for (type in result.numTypes) {
                if (type === NumType.EVEN) {
                    evenNumbers.add(i)
                } else if (type === NumType.ODD) {
                    oddNumbers.add(i)
                } else if (type === NumType.PRIME) {
                    primeNumbers.add(i)
                }
            }
        }
        return NumberProcessorResult(primeNumbers, oddNumbers, evenNumbers)
    }

    private fun evaluateNumber(num: Int): NumberEvaluationResult {
        val numTypes = mutableListOf<NumType>()
        var divisors = arrayOf(1)
        for (divider in 2..num) {
            if (num % divider == 0) {
                divisors += divider
            }
        }

        if (divisors.size == 2) {
            numTypes.add(NumType.PRIME)
        }
        if (num % 2 == 0) {
            numTypes.add(NumType.EVEN)
        }
        if (num % 2 == 1) {
            numTypes.add(NumType.ODD)
        }

        return NumberEvaluationResult(num, numTypes, divisors)
    }
}