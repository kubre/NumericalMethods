package in.kubre.numericalmethods.unit2;

import java.util.ArrayList;
import java.util.List;

/**
 * GaussJacobian
 */
public class JacobiMethod {

    private Matrix<Double> matrix;
    private List<Double> vector;
    List<Double> xPrev;
    List<Double> x;

    public JacobiMethod(Matrix<Double> matrix, List<Double> vector) {
        this.matrix = matrix;
        this.vector = vector;
    }

    public List<Double> approximate() {
        xPrev = new ArrayList<Double>(matrix.size());
        x = new ArrayList<Double>(matrix.size());
        int maxJ = matrix.rowSize();

        for (int i = 0; i < matrix.size(); i++) {
            xPrev.add(i, 0D);
            x.add(i, 0D);
        }

        double currentXApprox;
        for (int k = 0; k < matrix.size(); k++) {
            xPrev = x;
            for (int i = 0; i < matrix.size(); i++) {
                currentXApprox = 0;
                for (int j = 0; j < maxJ; j++) {
                    if (i != j) {
                        currentXApprox += matrix.get(i, j) * xPrev.get(j);
                    }
                }
                x.set(i, (1 / matrix.get(i, i) * (vector.get(i) - currentXApprox)));
            }
        }
        return x;
    }
}