package nn.evalpolynomial;

public class PolyElem {
    private int coef;
    private int exp;

    public PolyElem(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    @Override
    public String toString() {
        String s = "";
        if(coef == 0)
            s = s + "";
        else if(coef == 1)
            s = s + "x" + "^" + exp;
        else if(exp != 0)
            s = coef + "x" + "^" + exp;
        return s;
    }
}
