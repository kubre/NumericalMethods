package in.kubre.numericalmethods.root_finding;

/**
 *
 * @author kubre
 */
public class BisectionMethod extends RootFindingMethod {

    @Override
    protected double approximate(Values value) {
        return (value.a + value.b) / 2;
    }
}
