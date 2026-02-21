package nn.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Intro {

    public static void main(String[] args) {
        Stream stm = Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty","twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty");
        System.out.println(stm.toList());

        Stream.Builder builder = Stream.builder();
        builder.add("January");
        builder.add("February");

        builder.accept("March");
        
        stm = builder.build();

        System.out.println(stm.toList());

        stm = Stream.ofNullable("Nilam Kothari");
        System.out.println(stm.toList());
        
        stm = Stream.ofNullable(null);
        System.out.println(stm.toList());
        
        IntStream intStm = IntStream.of(100, 254, 872, 319, 645, 901, 112, 438, 763, 520, 889, 231, 476, 998, 105, 342, 677, 814, 290, 555);
        System.out.println(Arrays.toString(intStm.toArray()));

        intStm = IntStream.range(125, 145);
        System.out.println(Arrays.toString(intStm.toArray()));

        intStm = IntStream.rangeClosed(125, 145);
        System.out.println(Arrays.toString(intStm.toArray()));

        LongStream longStm = LongStream.of(112, 438, 763, 520, 889, 231, 476, 998, 105, 342);
        System.out.println(Arrays.toString(longStm.toArray()));

        DoubleStream doubleStm = DoubleStream.of(123.45, 678.90, 234.56, 789.01, 345.67, 890.12, 456.78, 901.23, 567.89, 612.34);
        System.out.println(Arrays.toString(doubleStm.toArray()));
    }
}
