package kg.ortools;

import com.google.ortools.Loader;
import com.google.ortools.sat.BoolVar;
import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.CpSolver;
import com.google.ortools.sat.CpSolverStatus;

import java.util.ArrayList;
import java.util.List;

public class KnapsackSolver {
    public Result solve(List<KnapsackItem> items, int capacity) {
        Loader.loadNativeLibraries();
        CpModel model = new CpModel();
        BoolVar[] take = new BoolVar[items.size()];
        for (int i = 0; i < items.size(); i++) take[i] = model.newBoolVar("take_" + i);

        com.google.ortools.sat.LinearExprBuilder weightExpr = com.google.ortools.sat.LinearExpr.newBuilder();
        com.google.ortools.sat.LinearExprBuilder valueExpr = com.google.ortools.sat.LinearExpr.newBuilder();
        for (int i = 0; i < items.size(); i++) {
            weightExpr.addTerm(take[i], items.get(i).weight());
            valueExpr.addTerm(take[i], items.get(i).value());
        }
        model.addLessOrEqual(weightExpr, capacity);
        model.maximize(valueExpr);

        CpSolver solver = new CpSolver();
        solver.getParameters().setMaxTimeInSeconds(10.0);
        CpSolverStatus status = solver.solve(model);
        if (status != CpSolverStatus.OPTIMAL && status != CpSolverStatus.FEASIBLE) {
            throw new IllegalStateException("No feasible solution returned by OR-Tools.");
        }

        List<KnapsackItem> selected = new ArrayList<>();
        int totalValue = 0;
        int totalWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            if (solver.booleanValue(take[i])) {
                selected.add(items.get(i));
                totalValue += items.get(i).value();
                totalWeight += items.get(i).weight();
            }
        }
        return new Result(selected, totalValue, totalWeight);
    }

    public record Result(List<KnapsackItem> selectedItems, int totalValue, int totalWeight) {}
}
