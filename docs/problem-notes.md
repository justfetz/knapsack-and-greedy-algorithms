# Problem Notes

## 0/1 Knapsack

- exact dynamic programming is a strong baseline when capacity is modest
- OR-Tools CP-SAT is useful when the model grows to include business constraints beyond simple weight

## Interval Activity Selection

- the canonical greedy proof uses earliest finish time ordering
- this is a good companion problem because it shows where greedy is exact without needing a full optimizer
