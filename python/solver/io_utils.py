from pathlib import Path
import csv

from .models import Activity, KnapsackItem


def read_knapsack_items(path: Path) -> list[KnapsackItem]:
    with path.open("r", encoding="utf-8", newline="") as handle:
        reader = csv.DictReader(handle)
        return [KnapsackItem(row["item_id"], int(row["value"]), int(row["weight"])) for row in reader]


def read_activities(path: Path) -> list[Activity]:
    with path.open("r", encoding="utf-8", newline="") as handle:
        reader = csv.DictReader(handle)
        return [Activity(row["activity_id"], int(row["start"]), int(row["end"])) for row in reader]
