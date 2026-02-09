
import java.util.function.Function;

interface A 
{
    void show();
}

public class Test {
    public static void main(String[] args) {
        // A obj =  () -> System.out.println("Helloo");
        // obj.show();

        // Function<Integer, String> f = (integer) ->  {return String.valueOf(integer);};
        // System.out.println(f.apply(10));
    }
}

// class Func implements Function<Integer, String>
// {
//     @Override
//     public String apply(Integer t) {
//         return String.valueOf(t);
//     }
// }