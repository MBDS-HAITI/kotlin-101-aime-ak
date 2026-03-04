package com.kotlin.one

/**
 * Automated demo of the Battle Arena game.
 * Shows the game mechanics without user input.
 */
fun demoGame() {
    println("\n" + "=".repeat(60))
    println("BATTLE ARENA - DEMO MODE")
    println("=".repeat(60))

    // Create teams
    val player1 = Player("Player 1")
    val player2 = Player("Player 2")

    println("\n--- Creating Teams ---\n")

    player1.addCharacter(Warrior("Aragorn"))
    player1.addCharacter(Magus("Gandalf"))
    player1.addCharacter(Dwarf("Gimli"))

    player2.addCharacter(Colossus("Goliath"))
    player2.addCharacter(Warrior("Legolas"))
    player2.addCharacter(Magus("Elara"))

    // Display teams
    player1.displayTeam()
    player2.displayTeam()

    // Simulate some battles
    println("\n" + "=".repeat(60))
    println("BATTLE DEMONSTRATION")
    println("=".repeat(60))

    // Demo: Warrior attacks Colossus
    println("\n--- Round 1: Demo Attack ---")
    val aragorn = player1.getTeam()[0] as Warrior
    val goliath = player2.getTeam()[0] as Colossus

    val damage = aragorn.attack()
    goliath.takeDamage(damage)
    println("${aragorn.name} attacks ${goliath.name}!")
    println("Damage: $damage")
    println("${goliath.name} status: $goliath")

    // Demo: Magus heals
    println("\n--- Round 2: Demo Heal ---")
    val gandalf = player1.getTeam()[1] as Magus
    val healAmount = gandalf.heal()
    aragorn.heal(healAmount)
    println("${gandalf.name} heals ${aragorn.name}!")
    println("Healed: $healAmount")
    println("${aragorn.name} status: $aragorn")

    // Demo: Dwarf strong attack
    println("\n--- Round 3: Demo Strong Attack ---")
    val gimli = player1.getTeam()[2] as Dwarf
    val strongDamage = gimli.attack()
    goliath.takeDamage(strongDamage)
    println("${gimli.name} attacks ${goliath.name}!")
    println("Damage: $strongDamage")
    println("${goliath.name} status: $goliath")

    println("\n" + "=".repeat(60))
    println("DEMO COMPLETE - Showing game mechanics")
    println("=".repeat(60))
}

/**
 * Main function for demo mode.
 */
fun main() {
    demoGame()
}

