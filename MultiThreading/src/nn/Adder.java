package nn;

public class Adder {

    static int Fund = 0;

    static class A implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                incrementValue();
            }
            
            // System.out.println("Fund:" + Fund);
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                incrementValue();
            }
            // System.out.println("Fund:" + Fund);
        }
    }

    public static synchronized void incrementValue() {
        Fund += 1;
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());

        // try{
            t1.start();
            t2.start();
    
            t1.join();
            t2.join();
        // }
        // catch(InterruptedException e){ e.getStackTrace(); }

        System.out.println("Fund:" + Fund);
    }
}
