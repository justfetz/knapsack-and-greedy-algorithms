# Knapsack And Greedy Algorithms

![CI](https://github.com/justfetz/knapsack-and-greedy-algorithms/actions/workflows/ci.yml/badge.svg)

Runnable Java, Python, and OR-Tools implementations for two foundational operations research patterns:

- `0/1 knapsack`
- `interval activity selection`

This repo is meant to be a clean public showcase with reproducible input files, output files, and simple local test harnesses.

## Repository layout

```text
knapsack-and-greedy-algorithms/
  input/
  output/
  docs/
  java/
  python/
  ortools-python/
```

## Problems included

### 0/1 Knapsack

Choose a subset of items to maximize total value without exceeding the weight capacity.

Tracks:

- Java dynamic programming baseline
- Python dynamic programming baseline
- Python OR-Tools CP-SAT model

### Interval Activity Selection

Choose the maximum number of non-overlapping activities from a fixed set of start/end intervals.

Tracks:

- Java greedy earliest-finish baseline
- Python greedy earliest-finish baseline

## Reproducible commands

Java:

```powershell
cd java
.\run-java.ps1
.\run-java-tests.ps1
```

Python:

```powershell
cd python
.\run-python.ps1
python -m pytest tests\test_algorithms.py
```

OR-Tools Python:

```powershell
cd ortools-python
.\run-ortools-python.ps1
python -m pytest tests\test_knapsack_ortools.py
```

Java OR-Tools:

```powershell
cd ortools-java
.\run-ortools-java.ps1
.\run-ortools-java-tests.ps1
```

Run all implementations:

```powershell
.\run-all.ps1
```

## Sample inputs

- [`input/sample_knapsack_items.csv`](./input/sample_knapsack_items.csv)
- [`input/sample_activities.csv`](./input/sample_activities.csv)

## Verified outputs

- [`output/knapsack_solution_java.csv`](./output/knapsack_solution_java.csv)
- [`output/knapsack_solution_python.csv`](./output/knapsack_solution_python.csv)
- [`output/knapsack_solution_ortools_java.csv`](./output/knapsack_solution_ortools_java.csv)
- [`output/knapsack_solution_ortools_python.csv`](./output/knapsack_solution_ortools_python.csv)
- [`output/activity_selection_java.csv`](./output/activity_selection_java.csv)
- [`output/activity_selection_python.csv`](./output/activity_selection_python.csv)

## Next steps

1. Add weighted interval scheduling.
2. Add job sequencing with deadlines and profits.
3. Add richer business constraints to the knapsack family.
