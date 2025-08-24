package nn;

// A Baker thread whose job is to bake a cake and place it on a shelf.
// A Customer thread whose job is to take the cake from the shelf.
// the shelf can only hold one cake at a time

// The baker can't put a new cake on the shelf if it's already full. He has to wait for the customer to take it.
// The customer can't take a cake if the shelf is empty. She has to wait for the baker to make a new one.

public class BakerAndCustomer {

    static boolean shelf = false;

    public static void makecake()
    {
        System.out.println("Cake is made");
    }

    public static synchronized void placeCake()
    {
        shelf = true;
        System.out.println("Cake placed at shelf");
    }

    public static synchronized void takeCake()
    {
        shelf = false;
        System.out.println("Cake is taken from shelf");
    } 

    static class Baker implements Runnable{

        @Override
        public void run() {
            makecake();
            placeCake();
        }
    }

    static class Customer implements Runnable{

        @Override
        public void run() {
            takeCake();
        }
    }

    public static void main(String[] args) {
       
        
        for (int i = 0; i < 10; i++) {
            Thread b = new Thread(new Baker());
            Thread c = new Thread(new Customer());

        
        }
        

    }
    
}
