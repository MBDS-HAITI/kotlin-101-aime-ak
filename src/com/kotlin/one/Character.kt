package com.kotlin.one

/**
 * Abstract base class for all characters in the battle arena.
 * Defines common properties and methods for all character types.
 */
abstract class Character(
    val name: String,
    val type: String,
    val maxHp: Int,
    val weapon: Weapon
) {
    var currentHp: Int = maxHp
    var isAlive: Boolean = true

    /**
     * Check if the character is still alive (HP > 0).
     */
    fun updateAliveStatus() {
        isAlive = currentHp > 0
    }

    /**
     * Take damage from an attack.
     */
    open fun takeDamage(damage: Int) {
        currentHp -= damage
        if (currentHp < 0) currentHp = 0
        updateAliveStatus()
    }

    /**
     * Heal the character.
     */
    open fun heal(healAmount: Int) {
        if (isAlive) {
            currentHp += healAmount
            if (currentHp > maxHp) currentHp = maxHp
        }
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Defines the action the character can perform.
     */
    abstract fun action(): String

    /**
     * Get character status as a string.
     */
    override fun toString(): String {
        return "$name ($type) - HP: $currentHp/$maxHp - ${if (isAlive) "ALIVE" else "DEAD"}"
    }
}

