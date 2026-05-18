from dataclasses import dataclass


@dataclass(frozen=True)
class KnapsackItem:
    item_id: str
    value: int
    weight: int
