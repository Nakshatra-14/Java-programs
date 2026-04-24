package nn.evalpolynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Polynomial {

    private List<PolyElem> ar;

    public Polynomial(int arCoef[], int arExp[])
    {
        ar = new ArrayList<>();
        for(int i = 0 ; i < arCoef.length ; i++)
        {
            ar.add(new PolyElem(arCoef[i], arExp[i]));
        }
        // ar.sort((a, b) -> b.getExp() - a.getExp());
        ar.sort(Comparator.comparing(PolyElem::getExp).reversed());
        // System.out.println(ar);
    }

    // public void consolidateExponent()
    //     {
    //         int exp, coef;

           
    //         for(int i = 0 ; i < ar.size() ; i++)
    //         {
    //             exp = ar.get(i).getExp();
    //             coef = ar.get(i).getCoef();

    //             if(i == ar.size()-1)
    //                 break;
    //             else
    //                 if(exp == ar.get(i+1).getExp())
    //                 {
    //                     int eval = coef + ar.get(i+1).getCoef();
    //                     ar.remove(i);
    //                     ar.remove(i);
    //                     if(eval != 0)
    //                         ar.add(i, new PolyElem(eval, exp));
    //                     i--;
    //                 }
    //         }

    //     }

    public void consolidateExponent()
    {
        for(int i = ar.size() -1 ; i > 0 ; i--)
        {
            int c = ar.get(i).getExp();
            int p = ar.get(i-1).getExp();

            if(c == p)
            {
                ar.get(i-1).coef += ar.get(i).coef;
                ar.remove(i);
                if(ar.get(i-1).getCoef() == 0)
                {
                    ar.remove(i-1);
                    i--;
                }

            }
        }
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
        if(sb.charAt(1) == '+')
            sb.delete(0, 3);
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
            
            if(coef == 0)
                return "";

            StringBuilder sb = new StringBuilder();

            sb.append(coef > 0 ? " + " : " - ");
            if(coef != 1 && coef != -1)
                sb.append(Math.abs(coef));
            if(exp != 0)
                sb.append("x");
            if(exp != 1)
                sb.append("^").append(exp);

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // int exp[] =  {7,    4,  3,-35, 4, 6, 1};
        // int coef[] = {45, -18, 21, 67, 1, 15, 3};

        int exp[] =  {7, 7, 3, 3, 3, 3, 1, 1};
        int coef[] = {1,-1, 3, 4, 5, 6, 7, 8};

        Polynomial poly = new Polynomial(coef, exp);
        System.out.println(poly);
        poly.consolidateExponent();
        System.out.println(poly);
    }
}
