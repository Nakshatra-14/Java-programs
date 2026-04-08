package stream.nn;

import java.util.function.IntSupplier;

public class PrimeGenerator implements IntSupplier{

    private static int n;

    public PrimeGenerator(int n) {
        this.n = n;
    }

    public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        else if(n == 2)
                return true;
        for (int i = 2 ; i * i <= n ; i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static int getNext(int n)
    {
        n++;
        if(n % 2 == 0)
            n++;
        while(true)
        {
            if(isPrime(n))
                break;
            n++;
        }
        return n;
    }
    
    public static int next()
    {   
        n = getNext(n);
        return n;
    }

    @Override
    public int getAsInt() {
        return next();
    }
}
