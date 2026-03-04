package com.kotlin.one

/**
 * Player class - Represents a player in the battle arena.
 * Each player manages a team of characters.
 */
class Player(val name: String) {
    private val team = mutableListOf<Character>()
    private val usedNames = mutableSetOf<String>()

    companion object {
        private val globalUsedNames = mutableSetOf<String>()
    }

    /**
     * Add a character to the player's team.
     * Ensures unique names across all players and unique types within the team.
     */
    fun addCharacter(character: Character): Boolean {
        // Check if name is globally unique
        if (globalUsedNames.contains(character.name)) {
            println("Error: Name '${character.name}' is already taken!")
            return false
        }

        // Check if type already exists in this team
        if (team.any { it.type == character.type }) {
            println("Error: ${character.type} already exists in ${name}'s team!")
            return false
        }

        // Add character
        team.add(character)
        usedNames.add(character.name)
        globalUsedNames.add(character.name)
        return true
    }

    /**
     * Get all characters in the team.
     */
    fun getTeam(): List<Character> = team

    /**
     * Get alive characters only.
     */
    fun getAliveCharacters(): List<Character> = team.filter { it.isAlive }

    /**
     * Check if any characters are still alive.
     */
    fun hasAliveCharacters(): Boolean = team.any { it.isAlive }

    /**
     * Select a character by index from alive characters.
     */
    fun selectCharacter(index: Int): Character? {
        val aliveChars = getAliveCharacters()
        return if (index in aliveChars.indices) aliveChars[index] else null
    }

    /**
     * Display the player's team status.
     */
    fun displayTeam() {
        println("\n${name}'s Team:")
        team.forEach { character ->
            println("  - $character")
        }
    }
}
