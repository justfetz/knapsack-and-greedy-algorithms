package kg;

public class KnapsackItem {
    private final String itemId;
    private final int value;
    private final int weight;

    public KnapsackItem(String itemId, int value, int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Item weight must be positive.");
        }
        this.itemId = itemId;
        this.value = value;
        this.weight = weight;
    }

    public String getItemId() { return itemId; }
    public int getValue() { return value; }
    public int getWeight() { return weight; }
}
