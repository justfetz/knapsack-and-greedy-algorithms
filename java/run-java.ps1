$javaHome = "C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot\bin"
$javac = Join-Path $javaHome "javac.exe"
$java = Join-Path $javaHome "java.exe"

New-Item -ItemType Directory -Force out | Out-Null
& $javac -d out src\kg\*.java
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

& $java -cp .\out kg.Main ..\input\sample_knapsack_items.csv 28 ..\input\sample_activities.csv ..\output\knapsack_solution_java.csv ..\output\activity_selection_java.csv
exit $LASTEXITCODE
