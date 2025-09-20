package nn.functional_interface;

import java.util.Arrays;
import java.util.Comparator;

public class ComperatorInterface {
    public static void main(String[] args) {
        String name[] = {"Amy", "John", "Elizabeth", "Maxwell"};
        // Arrays.sort(name);
        // System.out.println(Arrays.toString(name));

        Arrays.sort(name, new Comparator<String>(){

            @Override
            public int compare(String p, String q) {
                return p.length() - q.length();
            }

            
        });

        System.out.println(Arrays.toString(name));

        // Arrays.sort(name, (x, y) -> x.length() - y.length());
        // System.out.println(Arrays.toString(name));
    }
}
