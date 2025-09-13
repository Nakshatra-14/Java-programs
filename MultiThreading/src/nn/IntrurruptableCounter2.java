package nn;

import java.util.Random;

public class IntrurruptableCounter2 {

    boolean suspended = false;
    Thread intrurrupterThread , printerThread;

    IntrurruptableCounter2()
    {
        intrurrupterThread = new Thread(r1);
        printerThread = new Thread(r2);

        printerThread.start();
        intrurrupterThread.start();
    }

    synchronized void pause()
    {
        suspended = true;
    }

    synchronized void resume()
    {
        suspended = false;
        this.notify();
    }

    void quit()
    {
        printerThread.interrupt();
    }
    
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            Random rnd = new Random();
            boolean pause = false;
            int counter = 0;
            int n = 10;
            for (int i = 0; i < n; i++) {
                int r = rnd.nextInt(1, 5) * 1000;
                pause = !pause;
                System.out.println("No " + ++counter + " -----------------------------");
                if (pause) {
                    IntrurruptableCounter2.this.pause();
                    System.out.println("Paused for " + r / 1000 + " sec");
                } else {
                    System.out.println("Resume for " + r / 1000 + " sec");
                    IntrurruptableCounter2.this.resume();
                }

                try {
                    Thread.sleep(r);
                } catch (InterruptedException e) {
                }
            }
            IntrurruptableCounter2.this.quit();
            System.out.println("Finished");
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    System.out.println(ch);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // System.out.println("Finishing 1");
                        return;}
                    while(suspended)
                    {
                        synchronized (IntrurruptableCounter2.this) {
                            try {
                                IntrurruptableCounter2.this.wait();
                            } catch (InterruptedException ex) {
                                // System.out.println("Finishing 2");
                                return;}
                        }
                    }
                }
            }
        }
    };

    public static void main(String[] args) {
        new IntrurruptableCounter2();
    }
}
