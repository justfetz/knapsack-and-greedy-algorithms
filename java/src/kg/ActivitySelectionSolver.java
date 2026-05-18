package kg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionSolver {
    public List<Activity> solve(List<Activity> activities) {
        List<Activity> sorted = new ArrayList<>(activities);
        sorted.sort(Comparator.comparingInt(Activity::getEnd).thenComparingInt(Activity::getStart));

        List<Activity> selected = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;
        for (Activity activity : sorted) {
            if (activity.getStart() >= lastEnd) {
                selected.add(activity);
                lastEnd = activity.getEnd();
            }
        }
        return selected;
    }
}
