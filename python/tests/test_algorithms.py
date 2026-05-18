from pathlib import Path
import sys

sys.path.append(str(Path(__file__).resolve().parents[1]))

from solver.activity_selection import select_activities
from solver.io_utils import read_activities, read_knapsack_items
from solver.knapsack_solver import solve_knapsack


def test_knapsack_sample():
    items = read_knapsack_items(Path(__file__).resolve().parents[2] / "input" / "sample_knapsack_items.csv")
    result = solve_knapsack(items, 28)
    assert result["total_value"] == 56
    assert result["total_weight"] == 28
    assert len(result["selected_items"]) == 3


def test_activity_selection_sample():
    activities = read_activities(Path(__file__).resolve().parents[2] / "input" / "sample_activities.csv")
    result = select_activities(activities)
    assert [activity.activity_id for activity in result] == ["A1", "A4", "A8", "A11"]
