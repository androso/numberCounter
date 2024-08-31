package org.homework.common
enum class NumType {
    EVEN,
    PRIME,
    ODD
}
interface BaseNumber {
    val value: Int
    fun printValue() {
        println("The number is: $value")
    }

    fun checkType()
}

data class PrimeNumber(override val value: Int) : BaseNumber {
    override fun checkType() {
        println("The number $value is a prime number")
    }
}

data class OddNumber(override val value: Int, val dividers: Array<Int>) : BaseNumber {
    override fun checkType() {
        println("The number $value is an odd number")
    }

    fun printDividers() {
        println("The dividers of $value are: ${dividers.joinToString(", ")}")
    }
}

data class EvenNumber(override val value: Int, val dividers: Array<Int>) : BaseNumber {
    override fun checkType() {
        println("The number $value is an even number")
    }

    fun printDividers() {
        println("The dividers of $value are: ${dividers.joinToString(", ")}")
    }
}

data class NumberEvaluationResult(val number: Int, val numType: NumType, val dividers: Array<Int>)
