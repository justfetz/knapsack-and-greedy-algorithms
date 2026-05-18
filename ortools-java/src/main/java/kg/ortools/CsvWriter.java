package kg.ortools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {
    public void writeKnapsack(Path outputPath, KnapsackSolver.Result result) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("item_id,value,weight,total_value,total_weight");
        for (KnapsackItem item : result.selectedItems()) {
            lines.add(String.format("%s,%d,%d,%d,%d", item.itemId(), item.value(), item.weight(), result.totalValue(), result.totalWeight()));
        }
        Files.write(outputPath, lines);
    }
}
