package kg.tests;

import kg.Activity;
import kg.ActivitySelectionSolver;
import kg.KnapsackItem;
import kg.KnapsackResult;
import kg.KnapsackSolver;

import java.util.List;

public class TestAlgorithms {
    public static void main(String[] args) {
        testKnapsack();
        testActivitySelection();
        System.out.println("Java tests passed.");
    }

    private static void testKnapsack() {
        List<KnapsackItem> items = List.of(
            new KnapsackItem("I1", 24, 12),
            new KnapsackItem("I2", 13, 7),
            new KnapsackItem("I3", 23, 11),
            new KnapsackItem("I4", 15, 8),
            new KnapsackItem("I5", 16, 9),
            new KnapsackItem("I6", 28, 13)
        );
        KnapsackResult result = new KnapsackSolver().solve(items, 28);
        assertEquals(56, result.getTotalValue(), "knapsack total value");
        assertEquals(28, result.getTotalWeight(), "knapsack total weight");
        assertEquals(3, result.getSelectedItems().size(), "selected item count");
    }

    private static void testActivitySelection() {
        List<Activity> activities = List.of(
            new Activity("A1", 1, 4),
            new Activity("A2", 3, 5),
            new Activity("A4", 5, 7),
            new Activity("A8", 8, 11),
            new Activity("A11", 12, 16)
        );
        List<Activity> result = new ActivitySelectionSolver().solve(activities);
        assertEquals(4, result.size(), "activity count");
    }

    private static void assertEquals(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError("Expected " + label + " to be " + expected + " but was " + actual);
        }
    }
}
