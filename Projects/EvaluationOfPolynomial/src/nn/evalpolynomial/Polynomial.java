package nn.evalpolynomial;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    private  List<PolyElem> ar;

    public Polynomial(int arCoef[], int arExp[])
    {
        ar = new ArrayList<>();
        for(int i = 0 ; i < arCoef.length ; i++)
        {
            ar.add(new PolyElem(arCoef[i], arExp[i]));
        }
        ar.sort((a, b) -> b.getExp() - a.getExp());
    }

    // public long evaluate(int x)
    // {

    // }

    // public Polynomial add(Polynomial with)
    // {

    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PolyElem e : ar) {
            sb.append(e);
        }
        return sb.toString();
    }

    static class PolyElem {
        private int coef;
        private int exp;
    
        public int getCoef() {
            return coef;
        }

        public int getExp() {
            return exp;
        }

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
            else if(coef > 0)
                s = s + "+" + coef + "x" + "^" + exp;
            else if(exp != 0)
                s = coef + "x" + "^" + exp;
            return s;
        }
    }

    public static void main(String[] args) {
        int coef[] = {45, -18, 21, 67, 1, 0, 3};
        int exp[] = {7, 4, 3, -35, 4, 6, 1};

        Polynomial poly = new Polynomial(coef, exp);
        System.out.println(poly);
    }
}
