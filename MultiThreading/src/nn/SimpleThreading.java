package nn;

import java.util.Random;

class Assistant1 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Assistant 1 working on task: " + i);
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Assistant2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Assistant 2 working on task: " + i);
            try {
                Thread.sleep(new Random().nextInt(2000)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
public class SimpleThreading {
    public static void main(String[] args) {
        System.out.println("Starting");

        // Assistant a = new Assistant();
        // a.run();
        // Thread task = new Thread(a);
        // task.start();
        Thread t1 = new Thread(new Assistant1());
        Thread t2 = new Thread(new Assistant2());
        t1.start();
        t2.start();

        // for (int i = 0; i < 10; i++) {
        //     System.out.println("Main working on task: " + i);
        // }
    }
}
