#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p ../output
python3 main.py ../input/sample_knapsack_items.csv 28 ../input/sample_activities.csv ../output/knapsack_solution_python.csv ../output/activity_selection_python.csv
