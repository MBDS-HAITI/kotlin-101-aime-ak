@echo off
REM Battle Arena Test Script
REM This script demonstrates the Battle Arena game

echo ================================================================
echo            BATTLE ARENA - KOTLIN PROJECT
echo ================================================================
echo.
echo Project Structure:
echo - Weapon.kt              : Weapon class
echo - Interfaces.kt          : Attacker and Healer interfaces
echo - Character.kt           : Abstract Character base class
echo - CharacterTypes.kt      : Warrior, Magus, Colossus, Dwarf
echo - Player.kt              : Team management
echo - BattleArena.kt         : Game engine
echo - BattleArenaMain.kt     : Interactive game
echo - BattleArenaDemo.kt     : Automatic demo
echo.
echo ================================================================
echo TO RUN THE GAME:
echo ================================================================
echo.
echo 1. Open IntelliJ IDEA
echo 2. Go to: src/com/kotlin/one/BattleArenaMain.kt
echo 3. Click the Run button (green triangle) or press Shift+F10
echo.
echo OR for automatic demo:
echo 2. Go to: src/com/kotlin/one/BattleArenaDemo.kt
echo 3. Click the Run button
echo.
echo ================================================================
echo OOP CONCEPTS IMPLEMENTED:
echo ================================================================
echo.
echo - Class:           Character, Weapon, Player, BattleArena
echo - Inheritance:     All characters inherit from Character
echo - Interface:       Attacker, Healer
echo - Polymorphism:    Different attack() implementations
echo - Encapsulation:   Private properties with getters/setters
echo - Composition:     Character has a Weapon
echo - Abstraction:     Abstract Character class
echo.
echo ================================================================
echo CHARACTER STATS:
echo ================================================================
echo.
echo Warrior:  100 HP,  25 Power  - Balanced fighter
echo Magus:    120 HP,  15 Power  - Can heal (30-40 HP)
echo Colossus: 180 HP,  20 Power  - Very tanky
echo Dwarf:     60 HP,  35 Power  - Fragile but deadly
echo.
echo ================================================================
echo.
pause

