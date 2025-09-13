package nn.functional_interface;

@FunctionalInterface
interface Add
{
    int add(int x, int y);
}

public class Addable {
    public static void main(String[] args) {

        // Add adder = new Add()
        // {
        //     @Override
        //     public int add(int p, int q)
        //     {
        //         return p + q;
        //     }
        // };

        // int result = adder.add(10, 20);

        // System.out.println(result);

        //OR

        Add adder = (int p, int q) -> p+q;

        int result = adder.add(10, 20);

        System.out.println(result);
    }
}