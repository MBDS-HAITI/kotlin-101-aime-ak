# Battle Arena - Quick Run Script
# Compiles all Kotlin sources and runs the game

Write-Host "`n=== Battle Arena - Compilation & Execution ===" -ForegroundColor Cyan

# Step 1: Compile
Write-Host "`n[1/2] Compiling Kotlin sources..." -ForegroundColor Yellow
$files = Get-ChildItem ".\src\com\kotlin\one\*.kt" | ForEach-Object { $_.FullName }
kotlinc $files -include-runtime -d ".\battle-arena.jar"

if ($LASTEXITCODE -eq 0) {
    Write-Host "[OK] Compilation successful!" -ForegroundColor Green

    # Step 2: Run
    Write-Host "`n[2/2] Starting Battle Arena..." -ForegroundColor Yellow
    kotlin -classpath ".\battle-arena.jar" com.kotlin.one.BattleArenaMainKt
} else {
    Write-Host "[ERROR] Compilation failed!" -ForegroundColor Red
    exit 1
}

