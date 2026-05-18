package kg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackSolver {
    public KnapsackResult solve(List<KnapsackItem> items, int capacity) {
        int itemCount = items.size();
        int[][] dp = new int[itemCount + 1][capacity + 1];

        for (int i = 1; i <= itemCount; i++) {
            KnapsackItem item = items.get(i - 1);
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (item.getWeight() <= w) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - item.getWeight()] + item.getValue());
                }
            }
        }

        List<KnapsackItem> selected = new ArrayList<>();
        int remainingCapacity = capacity;
        int totalWeight = 0;
        for (int i = itemCount; i >= 1; i--) {
            if (dp[i][remainingCapacity] != dp[i - 1][remainingCapacity]) {
                KnapsackItem item = items.get(i - 1);
                selected.add(item);
                remainingCapacity -= item.getWeight();
                totalWeight += item.getWeight();
            }
        }

        Collections.reverse(selected);
        return new KnapsackResult(selected, dp[itemCount][capacity], totalWeight);
    }
}
