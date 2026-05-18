package kg.ortools;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: java kg.ortools.Main <items.csv> <capacity> <knapsack-output.csv>");
            return;
        }
        List<KnapsackItem> items = new CsvReaders().readKnapsackItems(Path.of(args[0]));
        int capacity = Integer.parseInt(args[1]);
        KnapsackSolver.Result result = new KnapsackSolver().solve(items, capacity);
        new CsvWriter().writeKnapsack(Path.of(args[2]), result);
        System.out.printf("Selected %d knapsack items worth %d.%n", result.selectedItems().size(), result.totalValue());
    }
}
