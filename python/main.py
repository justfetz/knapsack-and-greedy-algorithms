from pathlib import Path
import csv
import sys

from solver.io_utils import read_knapsack_items, read_activities
from solver.knapsack_solver import solve_knapsack
from solver.activity_selection import select_activities


def write_knapsack(path: Path, result):
    with path.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["item_id", "value", "weight", "total_value", "total_weight"])
        for item in result["selected_items"]:
            writer.writerow([item.item_id, item.value, item.weight, result["total_value"], result["total_weight"]])


def write_activities(path: Path, activities):
    with path.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["activity_id", "start", "end"])
        for activity in activities:
            writer.writerow([activity.activity_id, activity.start, activity.end])


if __name__ == "__main__":
    if len(sys.argv) < 6:
        raise SystemExit("Usage: python main.py <items.csv> <capacity> <activities.csv> <knapsack-output.csv> <activities-output.csv>")

    items = read_knapsack_items(Path(sys.argv[1]))
    capacity = int(sys.argv[2])
    activities = read_activities(Path(sys.argv[3]))
    knapsack_result = solve_knapsack(items, capacity)
    selected_activities = select_activities(activities)
    write_knapsack(Path(sys.argv[4]), knapsack_result)
    write_activities(Path(sys.argv[5]), selected_activities)
