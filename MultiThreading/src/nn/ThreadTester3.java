package nn;

public class ThreadTester3 {
    public static void main(String[] args) {
        Thread th8 = new Thread(new NumberPrinter(8));
        Thread th10 = new Thread(new NumberPrinter(10));

        th8.start();
        th10.start();
    }
}

class NumberPrinter implements Runnable {

    private int multipleOf;

    public NumberPrinter(int multipleOf)
    {
        this.multipleOf = multipleOf;
    }

    @Override
    public void run() {
        for(int i = 0 ; i <= 1000 ; i++)
            if(i % multipleOf == 0)
                System.out.println("Multiple of " + multipleOf + " " + i);
    }
}
