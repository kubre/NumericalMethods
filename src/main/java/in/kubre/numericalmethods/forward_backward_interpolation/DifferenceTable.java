package in.kubre.numericalmethods.forward_backward_interpolation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import in.kubre.numericalmethods.utils.Matrix;

/**
 * DifferenceTable
 */
public class DifferenceTable {

    private Matrix<Double> table;
    private boolean isCalculated = false;

    public DifferenceTable(List<Double> x, List<Double> y) {
        table = new Matrix<>(new LinkedList<>(Arrays.asList(x, y)));
    }

    public DifferenceTable calculate() {
        if(!isCalculated) {
            isCalculated = true;
            int n = table.get(1).size();
            for (int i = 2; i <= n; i++) {
                table.add(new LinkedList<>());
                for (int j = 0; j <= n - i; j++) {
                    table.add(i, table.get(i-1, j+1) - table.get(i-1, j));
                }
            }
        }
        return this;
    }

    public Matrix<Double> getTable() {
        return table;
    }
}