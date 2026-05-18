from .models import KnapsackItem


def solve_knapsack(items: list[KnapsackItem], capacity: int) -> dict:
    dp = [[0] * (capacity + 1) for _ in range(len(items) + 1)]
    for i, item in enumerate(items, start=1):
        for weight in range(capacity + 1):
            dp[i][weight] = dp[i - 1][weight]
            if item.weight <= weight:
                dp[i][weight] = max(dp[i][weight], dp[i - 1][weight - item.weight] + item.value)

    selected: list[KnapsackItem] = []
    remaining = capacity
    total_weight = 0
    for i in range(len(items), 0, -1):
        if dp[i][remaining] != dp[i - 1][remaining]:
            item = items[i - 1]
            selected.append(item)
            remaining -= item.weight
            total_weight += item.weight
    selected.reverse()
    return {"selected_items": selected, "total_value": dp[len(items)][capacity], "total_weight": total_weight}
