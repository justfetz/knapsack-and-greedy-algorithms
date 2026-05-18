package kg;

import java.util.List;

public class KnapsackResult {
    private final List<KnapsackItem> selectedItems;
    private final int totalValue;
    private final int totalWeight;

    public KnapsackResult(List<KnapsackItem> selectedItems, int totalValue, int totalWeight) {
        this.selectedItems = selectedItems;
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
    }

    public List<KnapsackItem> getSelectedItems() { return selectedItems; }
    public int getTotalValue() { return totalValue; }
    public int getTotalWeight() { return totalWeight; }
}
