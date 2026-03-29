
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface A {
    void show();
}

public class Test {
    public static void main(String[] args) throws IOException {
        // A obj = () -> System.out.println("Helloo");
        // obj.show();

        // Function<Integer, String> f = (integer) -> {return String.valueOf(integer);};
        // System.out.println(f.apply(10));

        List<Integer> lst = new ArrayList<>(1000);

        Random rnd = new Random();

        for(int i = 0 ; i < lst.size() ; i++)
            lst.add(rnd.nextInt(100));

        lst.forEach(e -> System.out.println(e));

        System.out.println("worked");
    }
}

// class Func implements Function<Integer, String>
// {
// @Override
// public String apply(Integer t) {
// return String.valueOf(t);
// }
// }