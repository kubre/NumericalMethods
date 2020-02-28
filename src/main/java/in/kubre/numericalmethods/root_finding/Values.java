package in.kubre.numericalmethods.root_finding;

/**
 * Value
 */
public class Values {
    public double a;
    public char aSign;
    public double fxa;
    
    public double b;
    public char bSign;
    public double fxb;

    public char lastChoosen;

    public Values(double a, double b, double fxa, double fxb, char lastChoosen) {
        this.a = a;
        this.fxa = fxa;
        this.aSign = this.fxa > 0 ? '+' : '-' ; 

        this.b = b;
        this.fxb = fxb;
        this.bSign = this.fxb > 0 ? '+' : '-' ; 

        this.lastChoosen = lastChoosen;
    }
}