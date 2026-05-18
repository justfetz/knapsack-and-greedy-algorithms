package kg;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 5) {
            System.out.println("Usage: java kg.Main <items.csv> <capacity> <activities.csv> <knapsack-output.csv> <activities-output.csv>");
            return;
        }

        CsvReaders readers = new CsvReaders();
        CsvWriters writers = new CsvWriters();

        List<KnapsackItem> items = readers.readKnapsackItems(Path.of(args[0]));
        int capacity = Integer.parseInt(args[1]);
        List<Activity> activities = readers.readActivities(Path.of(args[2]));

        KnapsackResult knapsackResult = new KnapsackSolver().solve(items, capacity);
        List<Activity> selectedActivities = new ActivitySelectionSolver().solve(activities);

        writers.writeKnapsack(Path.of(args[3]), knapsackResult);
        writers.writeActivities(Path.of(args[4]), selectedActivities);

        System.out.printf("Selected %d knapsack items worth %d and %d non-overlapping activities.%n",
            knapsackResult.getSelectedItems().size(),
            knapsackResult.getTotalValue(),
            selectedActivities.size());
    }
}
