from pathlib import Path
import sys

sys.path.append(str(Path(__file__).resolve().parents[1]))

from solver.io_utils import read_knapsack_items
from solver.knapsack_cp_sat import solve_knapsack_cp_sat


def test_knapsack_cp_sat_sample():
    items = read_knapsack_items(Path(__file__).resolve().parents[2] / "input" / "sample_knapsack_items.csv")
    result = solve_knapsack_cp_sat(items, 28)
    assert result["total_value"] == 56
    assert result["total_weight"] == 28
    assert len(result["selected_items"]) == 3
