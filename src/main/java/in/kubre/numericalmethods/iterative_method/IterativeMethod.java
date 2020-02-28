package in.kubre.numericalmethods.iterative_method;

import java.util.ArrayList;
import java.util.List;

/**
 * IterativeMethod
 */
public abstract class IterativeMethod {

    protected Matrix<Double> matrix;
    protected List<Double> xPrev;
    protected List<Double> x;

    public IterativeMethod(Matrix<Double> matrix) {
        this.matrix = matrix;
    }

    protected void resetVectors() {
        xPrev = new ArrayList<Double>(matrix.size());
        x = new ArrayList<Double>(matrix.size());
        
        for (int i = 0; i < matrix.size(); i++) {
            xPrev.add(i, 0D);
            x.add(i, 0D);
        }
    }

    public abstract List<Double> approximate();
}