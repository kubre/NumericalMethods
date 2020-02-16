/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.kubre.numericalmethods.unit1;

import java.util.ArrayList;
import java.util.List;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author kubre
 */
public class RegulaFalsi {

    private Expression fx;
    private String var;

    public RegulaFalsi(String fx, String var) {
        this.fx = new ExpressionBuilder(fx).variable(var).build();
        this.var = var;
    }

    public Values findInterval() throws Exception {
        double fx1;
        double fx2;
        for (int x = 0; x <= 5; x++) {
            fx1 = this.fx.setVariable(this.var, x).evaluate();
            fx2 = this.fx.setVariable(this.var, x + 1).evaluate();
            if ((fx1 < 0 && fx2 > 0) || (fx1 > 0 && fx2 < 0)) {
                return new Values(x, x + 1, fx1, fx2, ' ');
            }
        }
        for (int x = 0; x >= 5; x--) {
            fx1 = this.fx.setVariable(this.var, x).evaluate();
            fx2 = this.fx.setVariable(this.var, x - 1).evaluate();
            if ((fx1 < 0 && fx2 > 0) || (fx1 > 0 && fx2 < 0)) {
                return new Values(x, x - 1, fx1, fx2, ' ');
            }
        }
        throw new Exception("\\_(ovo)_/");
    }

    public ArrayList<Values> iterations(Values it) {
        // Approximations
        ArrayList<Values> ax = new ArrayList<>(5);
        double x;
        double fxx;
        char xSign;

        // First approximation
        ax.add(it);
        
        for (int i =0; i< 5; i++) {
            x = ((ax.get(i).a * ax.get(i).fxb - ax.get(i).b * ax.get(i).fxa) / (ax.get(i).fxb - ax.get(i).fxa));
            fxx = this.fx.setVariable(this.var, x).evaluate();
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
