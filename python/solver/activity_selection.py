from .models import Activity


def select_activities(activities: list[Activity]) -> list[Activity]:
    selected: list[Activity] = []
    last_end = float("-inf")
    for activity in sorted(activities, key=lambda item: (item.end, item.start, item.activity_id)):
        if activity.start >= last_end:
            selected.append(activity)
            last_end = activity.end
    return selected
