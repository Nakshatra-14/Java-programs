package nn.stream;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IntStreamTest {

    public static IntStream myIterate(int seed, Predicate hasNext, Function next)
    {
        IntStream.Builder b = IntStream.builder();
        for(int e = seed ; hasNext.test(e) ; e = (int) next.apply(e))
            b.add(e);
        return b.build();
    }

    public static void main(String[] args) {

        //Finite Stream
        // IntStream stm = myIterate(2,  (Predicate<Integer>) e -> e <= 100, (Function<Integer, Integer>) e -> PrimeGenerator.getNext(e));
        // stm = stm.limit(10);
        // System.out.println(Arrays.toString(stm.toArray()));

        // IntStream stm = IntStream.iterate(2,  e -> e <= 100, PrimeGenerator::getNext);
        // stm = stm.skip(10);
        // stm = stm.limit(10);
        // System.out.println(Arrays.toString(stm.toArray()));

        //infinite Stream
        // IntStream stm = IntStream.iterate(2, PrimeGenerator::getNext);
        // stm = stm.limit(300);
        // System.out.println(Arrays.toString(stm.toArray()));

        //infinite stream using generate
        PrimeGenerator pgen = new PrimeGenerator(2);
        IntStream stm = IntStream.generate(() -> pgen.next());
        // IntStream stm = IntStream.generate(PrimeGenerator::next);
        // IntStream stm = IntStream.generate(new PrimeGenerator(10).next());  //*
        // IntStream stm = IntStream.generate(pgen);
        stm = stm.limit(20);
        // System.out.println(Arrays.toString(stm.toArray()));

        //Random Integer using generator
        // IntStream stm = IntStream.generate(new Random()::nextInt);
        // IntStream stm = new Random().ints();
        // stm = stm.limit(20);
        
        stm.forEach(System.out::println);

        // Stream<Person> stm = Person.stream();
        // stm = stm.limit(2);
        // System.out.println(Arrays.toString(stm.filter(n -> n.getName().startsWith("H")).toArray()));
    }
}
