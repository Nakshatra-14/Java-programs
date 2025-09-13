package nn.functional_interface;

public class RunnableLamda {
    public static void main(String[] args) {
        
        // Runnable runner = new Runnable() {
        //     @Override
        //     public void run() {
        //        for(int i = 0 ; i < 10000 ; i++)
        //             System.out.println(i);
        //     }
        // };

        //OR

        Runnable runner = () -> {
            for(int i = 0 ; i < 10000 ; i++)
                System.out.println(i);
        };

        Thread t = new Thread(runner);
        t.start();
    }
}
