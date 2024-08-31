package org.homework

import org.homework.processors.NumberProcessor

fun main() {
    println("Please enter a number: ")

    val input = readLine();
    if (input?.toIntOrNull() == null || input == "") {
        println("Please enter a number")
        return;
    } else if (input.toInt() <= 0) {
        println("please enter a number starting from 1")
        return;
    }

    val number = input.toInt();
    val processor = NumberProcessor();

    val result = processor.processNumbers(number);
    println("The result of processing $number is: ");
    println("There are ${result.primesList.size} prime numbers from 1 up to $number")
    println("There are ${result.evensList.size} evens")
    println("There are ${result.oddsList.size} odds")
}
