package com.kotlin.one


// Exercise 1 — Immutable List
// Create an immutable list of 5 integers and return it.
fun ex1CreateImmutableList(): List<Int> {
    return listOf(1, 2, 3, 4, 5)
}

fun main() {
    // Test Exercise 1
    val result = ex1CreateImmutableList()
    println("Exercise 1 - Immutable List: $result")
    println("Size: ${result.size}")
    println("Elements: ${result.joinToString(", ")}")
}