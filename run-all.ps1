Write-Host "Running Java implementations..."
Push-Location ".\java"
powershell -ExecutionPolicy Bypass -File .\run-java.ps1
Pop-Location

Write-Host "Running Python implementations..."
Push-Location ".\python"
powershell -ExecutionPolicy Bypass -File .\run-python.ps1
Pop-Location

Write-Host "Running OR-Tools Python implementation..."
Push-Location ".\ortools-python"
powershell -ExecutionPolicy Bypass -File .\run-ortools-python.ps1
Pop-Location

Write-Host "Completed all runs."
