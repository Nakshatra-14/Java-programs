package nn;

public class ThreadTester2 {
    
    public static void main(String[] args) {
        Thread th8 = new Thread(new EightPrinter());
        Thread th10 = new Thread(new TenPrinter());

        th8.start();
        th10.start();
    }

    
    
}

class EightPrinter implements Runnable {

    @Override
    public void run() {
        for(int i = 0 ; i <= 1000 ; i++)
            if(i % 8 == 0)
                System.out.println("Multiply of 8 is: " + i);
    }
}

class TenPrinter implements Runnable {

    @Override
    public void run() {
        for(int i = 0 ; i <= 1000 ; i++)
            if(i % 10 == 0)
                System.out.println("Multiply of 10 is: " + i);
    }
}
