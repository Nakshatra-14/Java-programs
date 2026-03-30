
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

        int size = 1_000;
        List<Integer> lst = new ArrayList<>();

        Random rnd = new Random();

        for (int i = 0; i < size; i++)
            lst.add(rnd.nextInt(100));

        long seqStart = System.currentTimeMillis();
        int sum1 = lst.stream()
                        .map(e -> {
                            try {
                                Thread.sleep(1);
                            } catch (Exception ex) {}
                            return e*2;
                        })
                        .mapToInt(e -> e)
                        .sum();
        long seqEnd = System.currentTimeMillis();
        long paraStart = System.currentTimeMillis();
        int sum2 = lst.parallelStream()
                        .map(e -> {
                            try {
                                Thread.sleep(1);
                            } catch (Exception ex) {}
                            return e*2;
                        })
                        .mapToInt(e -> e)
                        .sum();
        long paraEnd = System.currentTimeMillis();

        System.out.println("Seq: " + (seqEnd - seqStart));
        System.out.println("Para: " + (paraEnd - paraStart));
    }
}

// class Func implements Function<Integer, String>
// {
// @Override
// public String apply(Integer t) {
// return String.valueOf(t);
// }
// }