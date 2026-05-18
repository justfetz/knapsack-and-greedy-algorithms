from ortools.sat.python import cp_model

from .models import KnapsackItem


def solve_knapsack_cp_sat(items: list[KnapsackItem], capacity: int) -> dict:
    model = cp_model.CpModel()
    take = [model.NewBoolVar(f"take_{index}") for index, _ in enumerate(items)]

    model.Add(sum(item.weight * take[index] for index, item in enumerate(items)) <= capacity)
    model.Maximize(sum(item.value * take[index] for index, item in enumerate(items)))

    solver = cp_model.CpSolver()
    solver.parameters.max_time_in_seconds = 10
    status = solver.Solve(model)
    if status not in (cp_model.OPTIMAL, cp_model.FEASIBLE):
        raise RuntimeError("No feasible solution returned by OR-Tools.")

    selected = [item for index, item in enumerate(items) if solver.Value(take[index]) == 1]
    return {
        "selected_items": selected,
        "total_value": sum(item.value for item in selected),
        "total_weight": sum(item.weight for item in selected),
    }
