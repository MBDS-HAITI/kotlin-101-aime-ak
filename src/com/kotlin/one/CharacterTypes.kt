package com.kotlin.one

/**
 * Warrior class - Balanced attacker.
 * Has medium HP and medium weapon power.
 */
class Warrior(name: String) : Character(name, "Warrior", 100, Weapon("Sword", 25)), Attacker {
    override fun action(): String = "Warrior $name prepares to attack!"

    override fun attack(): Int = weapon.power + (5..15).random()
}

/**
 * Magus class - Can heal allies and has weaker attacks.
 * Has high HP but low weapon power.
 */
class Magus(name: String) : Character(name, "Magus", 120, Weapon("Staff", 15)), Attacker, Healer {
    override fun action(): String = "Magus $name channels magical power!"

    override fun attack(): Int = weapon.power + (3..8).random()

    override fun heal(): Int = 30 + (5..10).random()
}

/**
 * Colossus class - Very resistant with medium attacks.
 * Has very high HP and medium weapon power.
 */
class Colossus(name: String) : Character(name, "Colossus", 180, Weapon("Hammer", 20)), Attacker {
    override fun action(): String = "Colossus $name shows immense strength!"

    override fun attack(): Int = weapon.power + (10..20).random()
}

/**
 * Dwarf class - Very strong but fragile.
 * Has low HP but very high weapon power.
 */
class Dwarf(name: String) : Character(name, "Dwarf", 60, Weapon("Axe", 35)), Attacker {
    override fun action(): String = "Dwarf $name swings with incredible force!"

    override fun attack(): Int = weapon.power + (10..25).random()
}

