package com.kotlin.one

/**
 * Interface for characters that can attack.
 */
interface Attacker {
    fun attack(): Int
}

/**
 * Interface for characters that can heal allies.
 */
interface Healer {
    fun heal(): Int
}