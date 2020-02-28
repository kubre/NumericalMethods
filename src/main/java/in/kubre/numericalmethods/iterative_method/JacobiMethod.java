package in.kubre.numericalmethods.iterative_method;

import java.util.List;

/**
 * GaussJacobian
 */
public class JacobiMethod extends IterativeMethod {

    public JacobiMethod(Matrix<Double> matrix) {
        super(matrix);
    }

    public List<Double> approximate() {
        resetVectors();

        int maxJ = matrix.rowSize() - 1;
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
                x.set(i, (1 / matrix.get(i, i) * (matrix.get(i, maxJ) - currentXApprox)));
            }
        }
        return x;
    }
}