package nn.functional_interface;

import java.util.Arrays;


@FunctionalInterface
interface ToIntConverter<T> {
    int getInt(T v);
}

public class ToIntConveterInterface {
    
    static <T> T getGreater(T p, T q, ToIntConverter<T> conv)
    {
        if(conv.getInt(p) > conv.getInt(q))
            return p;
        else
            return q;
    }

    public static void main(String[] args) {
        String a[] = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon"};

        String c = getGreater(a[0], a[1], s -> s.length());

        System.out.println(c);

        Arrays.sort(a, (x, y) -> x.length() - y.length());

        System.out.println(Arrays.toString(a));
    }
}
