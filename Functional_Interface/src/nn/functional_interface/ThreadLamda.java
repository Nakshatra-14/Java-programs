package nn.functional_interface;

public class ThreadLamda {
    public static void main(String[] args) {
        // new Thread(new Runnable()
        // {
        //     public void run()
        //     {
        //         for(int i = 0 ; i < 10000 ; i++)
        //         System.out.println(i);
        //     }
        // }).start();

        //OR

        new Thread(() -> {
            for(int i = 0 ; i < 10000 ; i++)
                System.out.println(i);
        }).start();
    }
}
