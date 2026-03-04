package com.kotlin.one

import kotlin.math.abs

/**
 * BattleArena class - Main game controller.
 * Manages the battle between two players and their teams.
 */
class BattleArena(val player1: Player, val player2: Player) {
    private var turns = 0
    private var currentPlayer: Player = player1
    private var opposingPlayer: Player = player2

    /**
     * Start the battle and manage the game loop.
     */
    fun startBattle() {
        println("\n" + "=".repeat(60))
        println("WELCOME TO BATTLE ARENA!")
        println("=".repeat(60))

        // Display teams
        player1.displayTeam()
        player2.displayTeam()

        // Main game loop
        while (player1.hasAliveCharacters() && player2.hasAliveCharacters()) {
            executeTurn()
            switchPlayers()
        }

        // Display results
        endBattle()
    }

    /**
     * Execute one turn of the battle.
     */
    private fun executeTurn() {
        turns++
        println("\n" + "-".repeat(60))
        println("TURN $turns - ${currentPlayer.name}'s turn")
        println("-".repeat(60))

        val character = selectCharacterForTurn() ?: return

        println("\nAvailable actions:")
        println("1. Attack")
        if (character is Healer) {
            println("2. Heal")
        }

        print("\nChoose action (1${if (character is Healer) "/2" else ""}): ")
        val action = readLine()?.toIntOrNull() ?: 1

        when (action) {
            1 -> performAttack(character)
            2 -> if (character is Healer) performHeal(character) else performAttack(character)
            else -> performAttack(character)
        }
    }

    /**
     * Select a character for the turn.
     */
    private fun selectCharacterForTurn(): Character? {
        val aliveCharacters = currentPlayer.getAliveCharacters()
        if (aliveCharacters.isEmpty()) return null

        println("\nSelect character to act:")
        aliveCharacters.forEachIndexed { index, character ->
            println("  ${index + 1}. $character")
        }

        print("Choose character (1-${aliveCharacters.size}): ")
        val choice = readLine()?.toIntOrNull() ?: 1
        return currentPlayer.selectCharacter(choice - 1)
    }

    /**
     * Perform an attack action.
     */
    private fun performAttack(attacker: Character) {
        if (attacker !is Attacker) {
            println("${attacker.name} cannot attack!")
            return
        }

        val targets = opposingPlayer.getAliveCharacters()
        if (targets.isEmpty()) return

        println("\nSelect target to attack:")
        targets.forEachIndexed { index, character ->
            println("  ${index + 1}. $character")
        }

        print("Choose target (1-${targets.size}): ")
        val choice = readLine()?.toIntOrNull() ?: 1
        val target = targets.getOrNull(choice - 1) ?: return

        val damage = attacker.attack()
        println("\n${attacker.name} attacks ${target.name}!")
        println("${attacker.name} uses ${attacker.weapon}")
        target.takeDamage(damage)
        println("Dealt $damage damage!")
        println("${target.name} now has ${target.currentHp}/${target.maxHp} HP")

        if (!target.isAlive) {
            println("\n⚰️  ${target.name} has been defeated!")
        }
    }

    /**
     * Perform a heal action.
     */
    private fun performHeal(healer: Character) {
        if (healer !is Healer) {
            println("${healer.name} cannot heal!")
            return
        }

        val allies = currentPlayer.getAliveCharacters()
        if (allies.isEmpty()) return

        println("\nSelect ally to heal:")
        allies.forEachIndexed { index, character ->
            println("  ${index + 1}. $character")
        }

        print("Choose target (1-${allies.size}): ")
        val choice = readLine()?.toIntOrNull() ?: 1
        val target = allies.getOrNull(choice - 1) ?: return

        val healAmount = healer.heal()
        println("\n${healer.name} casts a healing spell on ${target.name}!")
        target.heal(healAmount)
        println("Healed $healAmount HP!")
        println("${target.name} now has ${target.currentHp}/${target.maxHp} HP")
    }

    /**
     * Switch the active player for the next turn.
     */
    private fun switchPlayers() {
        val temp = currentPlayer
        currentPlayer = opposingPlayer
        opposingPlayer = temp
    }

    /**
     * End the battle and display results.
     */
    private fun endBattle() {
        println("\n" + "=".repeat(60))
        println("BATTLE ENDED!")
        println("=".repeat(60))

        val winner = if (player1.hasAliveCharacters()) player1 else player2
        val loser = if (winner == player1) player2 else player1

        println("\n🏆 WINNER: ${winner.name}!")
        println("\nTotal turns played: $turns")

        println("\n${winner.name}'s Team (Survivors):")
        winner.getTeam().forEach { character ->
            println("  ✓ $character")
        }

        println("\n${loser.name}'s Team (Defeated):")
        loser.getTeam().forEach { character ->
            println("  ✗ $character")
        }

        println("\n" + "=".repeat(60))
    }
}

