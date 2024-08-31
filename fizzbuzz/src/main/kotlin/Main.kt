package org.fizzbuzz

import org.fizzbuzz.engines.FizzBuzz

fun main() {
    println("Enter a number to end fizzbuz at: ")

    val input = readLine()
    if (input?.toIntOrNull() == null || input == "") {
        println("Please enter a number")
        return
    }

    val limit = input.toInt()
    val fizzBuzzEngine = FizzBuzz()
    try {
        val result = fizzBuzzEngine.process(1, limit)
        println(result)
        return
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}