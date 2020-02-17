package in.kubre.numericalmethods.unit1;
/**
 *
 * @author kubre
 */
public class RegulaFalsiMethod extends RootFindingMethod {

    @Override
    protected double approximate(Values value) {
        return ((value.a * value.fxb - value.b * value.fxa) / (value.fxb - value.fxa));
    }
}
