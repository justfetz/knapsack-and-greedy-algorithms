package kg.ortools;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackSolverTest {
    @Test
    void sampleKnapsackMatchesExpectedValue() throws Exception {
        List<KnapsackItem> items = new CsvReaders().readKnapsackItems(Path.of("..", "input", "sample_knapsack_items.csv"));
        KnapsackSolver.Result result = new KnapsackSolver().solve(items, 28);
        assertEquals(56, result.totalValue());
        assertEquals(28, result.totalWeight());
        assertEquals(3, result.selectedItems().size());
    }
}
