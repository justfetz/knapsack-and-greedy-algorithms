from pathlib import Path
import csv
import sys

from solver.io_utils import read_knapsack_items
from solver.knapsack_cp_sat import solve_knapsack_cp_sat


if __name__ == "__main__":
    if len(sys.argv) < 4:
        raise SystemExit("Usage: python main.py <items.csv> <capacity> <knapsack-output.csv>")

    items = read_knapsack_items(Path(sys.argv[1]))
    capacity = int(sys.argv[2])
    result = solve_knapsack_cp_sat(items, capacity)

    with Path(sys.argv[3]).open("w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["item_id", "value", "weight", "total_value", "total_weight"])
        for item in result["selected_items"]:
            writer.writerow([item.item_id, item.value, item.weight, result["total_value"], result["total_weight"]])
