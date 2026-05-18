package kg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReaders {
    public List<KnapsackItem> readKnapsackItems(Path inputPath) throws IOException {
        List<String> lines = Files.readAllLines(inputPath);
        List<KnapsackItem> items = new ArrayList<>();
        for (int index = 1; index < lines.size(); index++) {
            String line = lines.get(index).trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split(",");
            items.add(new KnapsackItem(tokens[0].trim(), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[2].trim())));
        }
        return items;
    }

    public List<Activity> readActivities(Path inputPath) throws IOException {
        List<String> lines = Files.readAllLines(inputPath);
        List<Activity> activities = new ArrayList<>();
        for (int index = 1; index < lines.size(); index++) {
            String line = lines.get(index).trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split(",");
            activities.add(new Activity(tokens[0].trim(), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[2].trim())));
        }
        return activities;
    }
}
