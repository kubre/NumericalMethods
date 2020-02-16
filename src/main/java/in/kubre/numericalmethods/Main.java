package in.kubre.numericalmethods;

import java.util.ArrayList;

import in.kubre.numericalmethods.unit1.RegulaFalsi;
import in.kubre.numericalmethods.unit1.Values;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author kubre
 */
public class Main {

    public static void main(String args[]) {
        try {
            RegulaFalsi r = new RegulaFalsi("cos(x)-3x+1", "x");
            Values interval = r.findInterval();
            ArrayList<Values> apporxs = r.iterations(interval);
            int i = 0;
            double xi = 0;
            double fxi = 0;
            System.out.println("#\ta\tb\txi\tf(xi)");
            System.out.println("---------------------------------------");
            for (Values v: apporxs) {
                if (i<4) {
                    xi = apporxs.get(i+1).lastChoosen == 'a' ? apporxs.get(i+1).a : apporxs.get(i+1).b;
                    fxi = apporxs.get(i+1).lastChoosen == 'a' ? apporxs.get(i+1).fxa : apporxs.get(i+1).fxb;
                }
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\n", i, v.a, v.b, xi, fxi);
                i++;
            }
            System.out.println("---------------------------------------");
            System.out.printf("Approx. of root with Regula Falsi method is %.4f\n", xi);
        } catch (Exception ex) {
        }
    }
}
