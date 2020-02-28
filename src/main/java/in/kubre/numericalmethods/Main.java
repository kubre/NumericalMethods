package in.kubre.numericalmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.kubre.numericalmethods.root_finding.BisectionMethod;
import in.kubre.numericalmethods.root_finding.RegulaFalsiMethod;
import in.kubre.numericalmethods.root_finding.Values;
import in.kubre.numericalmethods.iterative_method.GaussSeidelMethod;
import in.kubre.numericalmethods.iterative_method.IterativeMethod;
import in.kubre.numericalmethods.iterative_method.JacobiMethod;
import in.kubre.numericalmethods.iterative_method.Matrix;

/**
 *
 * @author kubre
 */
public class Main {

    public static void main(String args[]) {
        // iterativeMethodExample();
        jacobiMethodExample();
        seidelMethodExample();
    }

    private static void seidelMethodExample() {
        Matrix<Double> matrix = new Matrix<>(Arrays.asList(
            Arrays.asList(10D, 1D, -1D, 11.19D),
            Arrays.asList(1D, 10D, 1D, 28.08D),
            Arrays.asList(-1D, 1D, 10D, 35.61D)
        ));

        IterativeMethod j = new GaussSeidelMethod(matrix);
        List<Double> jApproxs = j.approximate();

        System.out.println("Sediel Method");
        for (int i = 0; i < jApproxs.size(); i++) {
            System.out.printf("x%d: %.4f\n", i, jApproxs.get(i));
        }
    }

    private static void jacobiMethodExample() {
        Matrix<Double> matrix = new Matrix<>(Arrays.asList(
            Arrays.asList(10D, 1D, -1D, 11.19D),
            Arrays.asList(1D, 10D, 1D, 28.08D),
            Arrays.asList(-1D, 1D, 10D, 35.61D)
        ));
        // List<Double> vector = new ArrayList<>(3);

        // vector.addAll(Arrays.asList());

        IterativeMethod j = new JacobiMethod(matrix);
        List<Double> jApproxs = j.approximate();

        System.out.println("Jacobi Method");
        for (int i = 0; i < jApproxs.size(); i++) {
            System.out.printf("x%d: %.4f\n", i, jApproxs.get(i));
        }
    }

    private static void iterativeMethodExample() {
        try {
            String eqn = "x^4-x-10";
            ArrayList<Values> rApporxs = (new RegulaFalsiMethod()).performIterations(3).find(eqn);
            ArrayList<Values> bApporxs = (new BisectionMethod()).performIterations(3).find(eqn);
            int i = 0;
            double xi = 0;
            double fxi = 0;

            System.out.println("Reguli Falsi Method");
            System.out.println("#\ta\tb\txi\tf(xi)");
            System.out.println("---------------------------------------");
            for (Values v : rApporxs) {
                if (i < 2) {
                    xi = rApporxs.get(i + 1).lastChoosen == 'a' ? rApporxs.get(i + 1).a : rApporxs.get(i + 1).b;
                    fxi = rApporxs.get(i + 1).lastChoosen == 'a' ? rApporxs.get(i + 1).fxa : rApporxs.get(i + 1).fxb;
                }
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\n", i, v.a, v.b, xi, fxi);
                i++;
            }
            System.out.println("---------------------------------------");
            System.out.printf("Approx. of root with Regula Falsi method is %.4f\n", xi);

            i = 0;
            System.out.println("\nBisection Method");
            System.out.println("#\ta\tb\txi\tf(xi)");
            System.out.println("---------------------------------------");
            for (Values v : bApporxs) {
                if (i < 2) {
                    xi = bApporxs.get(i + 1).lastChoosen == 'a' ? bApporxs.get(i + 1).a : bApporxs.get(i + 1).b;
                    fxi = bApporxs.get(i + 1).lastChoosen == 'a' ? bApporxs.get(i + 1).fxa : bApporxs.get(i + 1).fxb;
                }
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\n", i, v.a, v.b, xi, fxi);
                i++;
            }
            System.out.println("---------------------------------------");
            System.out.printf("Approx. of root with Bisection method is %.4f\n", xi);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
