package nn.stream;

@java.lang.FunctionalInterface
interface BasicMathOperation<T> {
    T operation(T a, T b);
}

@java.lang.FunctionalInterface
interface MathOperation<T> {
    double operation(T ... n);
}

@java.lang.FunctionalInterface
interface StringCombiner {
    String join(String delimitter, String ... s);
}

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        // //check even no.
        // Predicate<Integer> isEven = n -> n % 2 == 0;
        // System.out.println(isEven.test(10));
        
        // //Write a Predicate<String> that checks if a password is longer than 8 characters. Test it with "pass123" and "password1234"
        // Predicate<String> checkPassword = n -> n.length() >= 8;
        // System.out.println(checkPassword.test("Password123"));

        // //Write a Function<Integer, Integer> that takes a number and returns its square (e.g., input 5 -> output 25)
        // Function<Integer, Integer> getSquare = n -> n*n;
        // System.out.println(getSquare.apply(4));

        // BasicMathOperation<Integer> addOperation = (a, b) -> a + b;
        // BasicMathOperation<Integer> subOperation = (a, b) -> a - b;
        // System.out.println(addOperation.operation(10, 35));
        // System.out.println(subOperation.operation(30, 16));

        // MathOperation<Double> doubleAvg = n -> {
        //     double a = 0;
        //     for(double e : n)
        //         a += e;
        //     return a/n.length;
        // };
        // System.out.println(doubleAvg.operation(678.90, 234.56, 789.01, 345.67));

        // Predicate<String> usernameValidator = s -> (s.length() >= 5 && !s.isEmpty());
        // System.out.println(usernameValidator.test("user123"));

        // Function<String, Double> priceConverterAndTaxAmt = n -> {
        //     n = n.trim();
        //     double value = Double.parseDouble(n);
        //     return value * 0.18;
        // };
        // System.out.println(priceConverterAndTaxAmt.apply("100"));

        // Consumer<String> errorLog = n -> System.out.println("[ERROR]: " + n + " -- " + GregorianCalendar.getInstance().getTime());
        // errorLog.accept("Array out of bound");

        // Supplier<String> otpGen = () -> {
        //     int min = 1111;
        //     int max = 9999;
        //     return String.valueOf((int) (Math.random() * (max - min + 1) + min));
        // };
        // System.out.println(otpGen.get());

        // StringCombiner stringCombiner = (d, arr) -> {
        //     StringBuilder sb = new StringBuilder();
        //     for(int i = 0 ; i < arr.length ; i++)
        //     {
        //         if(i != 0)
        //             sb.append(d);
        //         sb.append(arr[i]);
        //     }
        //     return sb.toString(); 
        // };
        // System.out.println(stringCombiner.join("-", "This", "is", "a", "is"));

        // String name = "";
        // System.out.println(Stream.ofNullable(name).filter( n -> (n.length() >= 5 && !n.isEmpty())).toList());
        
        // Consumer<String> sp = System.out::println;
        // Consumer<String> sp = n -> System.out.println(n);
        // sp.accept("abcd");

       
    }
}
