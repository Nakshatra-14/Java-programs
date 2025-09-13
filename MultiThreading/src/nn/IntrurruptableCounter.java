package nn;

import java.util.Random;

class Intrrupter implements Runnable {

    LetterPrinter lp;

    Intrrupter(LetterPrinter lp)
    {
        this.lp = lp;
    }

    Random rnd = new Random();

    @Override
    public void run() {
        boolean pause = false;
        int counter = 0;
        int n = 10;
        for (int i = 0; i < n; i++) {
            int r = rnd.nextInt(1, 5) * 1000;
            pause = !pause;
            System.out.println("No " + ++counter + " -----------------------------");
            if(pause)
            {
                lp.pause();
                System.out.println("Paused for " + r/1000 + " sec");
            }
            else
            {
                System.out.println("Resume for " + r/1000 + " sec");
                lp.resume();
            }
            
            try {
                Thread.sleep(r);
            } catch (InterruptedException e) {}
        }
        lp.quit();
        System.out.println("Finished");
    }

}

class LetterPrinter implements Runnable {

    private boolean suspended = false;
    Thread th;

    synchronized void pause()
    {
        suspended = true;
    }

    synchronized void resume()
    {
        suspended = false;
        this.notify();
    }

    synchronized void quit()
    {
        th.interrupt();
    }

    @Override
    public void run() {
        th = Thread.currentThread();
        while (true) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.println(ch);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {return;}
                while(suspended)
                {
                    synchronized (this) {
                        try {
                            this.wait();
                        } catch (InterruptedException ex) {return;}
                    }
                }
            }
        }
    }

}

public class IntrurruptableCounter {

    public static void main(String[] args) {
        LetterPrinter lp = new LetterPrinter();
        Intrrupter i = new Intrrupter(lp);
        Thread t1 = new Thread(i);
        Thread t2 = new Thread(lp);
        t2.start();
        t1.start();
    }
}
