from dataclasses import dataclass


@dataclass(frozen=True)
class KnapsackItem:
    item_id: str
    value: int
    weight: int


@dataclass(frozen=True)
class Activity:
    activity_id: str
    start: int
    end: int
