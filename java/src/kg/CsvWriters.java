package kg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvWriters {
    public void writeKnapsack(Path outputPath, KnapsackResult result) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("item_id,value,weight,total_value,total_weight");
        for (KnapsackItem item : result.getSelectedItems()) {
            lines.add(String.format("%s,%d,%d,%d,%d", item.getItemId(), item.getValue(), item.getWeight(), result.getTotalValue(), result.getTotalWeight()));
        }
        Files.write(outputPath, lines);
    }

    public void writeActivities(Path outputPath, List<Activity> activities) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("activity_id,start,end");
        for (Activity activity : activities) {
            lines.add(String.format("%s,%d,%d", activity.getActivityId(), activity.getStart(), activity.getEnd()));
        }
        Files.write(outputPath, lines);
    }
}
