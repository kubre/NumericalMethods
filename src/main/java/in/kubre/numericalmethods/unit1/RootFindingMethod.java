package in.kubre.numericalmethods.unit1;

import java.util.ArrayList;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author kubre
 */
public abstract class RootFindingMethod {

    private int iterationCount = 5;

    protected abstract double approximate(Values value);

    public ArrayList<Values> find(String sfx) {
        return this.find(sfx, "x");
    }

    public RootFindingMethod performIterations(int iterationCount) {
        this.iterationCount = iterationCount;
        return this;
    }

    public ArrayList<Values> find(String sfx, String var) {
        /* TODO: Find a better way to calculate expressions */
        Expression fx = new ExpressionBuilder(sfx).variable(var).build();

        double fx1, fx2, x, fxx;
        char xSign;

        // Approximations
        ArrayList<Values> ax = new ArrayList<>(iterationCount);

        for (int i = 0; i <= iterationCount; i++) {
            fx1 = fx.setVariable(var, i).evaluate();
            fx2 = fx.setVariable(var, i + 1).evaluate();
            if ((fx1 < 0 && fx2 > 0) || (fx1 > 0 && fx2 < 0)) {
                ax.add(new Values(i, i + 1, fx1, fx2, ' '));
            }
        }

        for (int i = 0; i >= iterationCount; i--) {
            fx1 = fx.setVariable(var, i).evaluate();
            fx2 = fx.setVariable(var, i - 1).evaluate();
            if ((fx1 < 0 && fx2 > 0) || (fx1 > 0 && fx2 < 0)) {
                ax.add(new Values(i, i - 1, fx1, fx2, ' '));
            }
        }

        for (int i = 0; i < iterationCount; i++) {
            x = this.approximate(ax.get(i));
            fxx = fx.setVariable(var, x).evaluate();
            xSign = fxx > 0 ? '+' : '-';
            if (xSign == ax.get(i).aSign) {
                ax.add(new Values(x, ax.get(i).b, fxx, ax.get(i).fxb, 'a'));
            } else {
                ax.add(new Values(ax.get(i).a, x, ax.get(i).fxa, fxx, 'b'));
            }
        }
        return ax;
    }
}
