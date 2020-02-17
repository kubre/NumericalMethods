package in.kubre.numericalmethods;

import java.util.ArrayList;
import in.kubre.numericalmethods.unit1.BisectionMethod;
import in.kubre.numericalmethods.unit1.RegulaFalsiMethod;
import in.kubre.numericalmethods.unit1.Values;
/**
 *
 * @author kubre
 */
public class Main {

    public static void main(String args[]) {
        try {
            String eqn = "x^4-x-10";
            ArrayList<Values> rApporxs = (new RegulaFalsiMethod()).approximate(eqn);
            ArrayList<Values> bApporxs = (new BisectionMethod()).approximate(eqn);
            int i = 0;
            double xi = 0;
            double fxi = 0;

            System.out.println("Bisection Method");
            System.out.println("#\ta\tb\txi\tf(xi)");
            System.out.println("---------------------------------------");
            for (Values v: bApporxs) {
                if (i<4) {
                    xi = rApporxs.get(i+1).lastChoosen == 'a' ? rApporxs.get(i+1).a : rApporxs.get(i+1).b;
                    fxi = rApporxs.get(i+1).lastChoosen == 'a' ? rApporxs.get(i+1).fxa : rApporxs.get(i+1).fxb;
                }
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\n", i, v.a, v.b, xi, fxi);
                i++;
            }
            System.out.println("---------------------------------------");
            System.out.printf("Approx. of root with Regula Falsi method is %.4f\n", xi);

            i=0;
            System.out.println("\nBisection Method");
            System.out.println("#\ta\tb\txi\tf(xi)");
            System.out.println("---------------------------------------");
            for (Values v: bApporxs) {
                if (i<4) {
                    xi = bApporxs.get(i+1).lastChoosen == 'a' ? bApporxs.get(i+1).a : bApporxs.get(i+1).b;
                    fxi = bApporxs.get(i+1).lastChoosen == 'a' ? bApporxs.get(i+1).fxa : bApporxs.get(i+1).fxb;
                }
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\n", i, v.a, v.b, xi, fxi);
                i++;
            }
            System.out.println("---------------------------------------");
            System.out.printf("Approx. of root with Bisection method is %.4f\n", xi);
        } catch (Exception ex) {
        }
    }
}
