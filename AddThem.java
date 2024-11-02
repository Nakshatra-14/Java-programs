public class AddThem {
    public static void main(String[] args) {
        int n = 0;
        for(String s : args)
            n += Integer.parseInt(s);
        System.out.println("Sum = " + n);
    }
}
