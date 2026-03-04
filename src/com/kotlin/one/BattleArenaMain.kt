package com.kotlin.one

/**
 * Main entry point for the Battle Arena game.
 * Creates two players, their teams, and starts the battle.
 */
fun main() {
    println("\n╔═══════════════════════════════════════════════════════════╗")
    println("║           WELCOME TO BATTLE ARENA GAME!                  ║")
    println("║          A Console-Based RPG Battle System                ║")
    println("╚═══════════════════════════════════════════════════════════╝")

    // Create players
    val player1 = Player("Player 1")
    val player2 = Player("Player 2")

    // Setup Player 1's team
    println("\n--- Setting up ${player1.name}'s Team ---")
    player1.addCharacter(Warrior("Aragorn"))
    player1.addCharacter(Magus("Gandalf"))
    player1.addCharacter(Dwarf("Gimli"))

    // Setup Player 2's team
    println("\n--- Setting up ${player2.name}'s Team ---")
    player2.addCharacter(Colossus("Goliath"))
    player2.addCharacter(Warrior("Legolas"))
    player2.addCharacter(Magus("Elara"))

    // Create and start the battle
    val battle = BattleArena(player1, player2)
    battle.startBattle()

    println("\nThanks for playing Battle Arena!")
}

