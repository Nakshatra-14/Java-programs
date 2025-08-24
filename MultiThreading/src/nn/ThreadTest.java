package nn;

public class ThreadTest {

    public ThreadTest()
    {}

    public static void showMultiples(int n)
    {
        int i = 1;

        do{
            System.out.println("Multiples of " + n + " = " + n * i);
            ++i;
        }while(i != 200);
    }

    public static void main(String[] args) {
        int arr1[] = {3, 7};
        int arr2[] = arr1;

        int l = arr1.length;

        for(int i = 0 ; i < l ; i++)
        {
            int v = arr2[i];
            ThreadTest tt = new ThreadTest();
            Thread t = new Thread(tt);
            t.start();

            try
            {
                t.join();
            }
            catch(InterruptedException e) 
            {
                System.out.println("Interrupted: " + t.getName());
            }
        }
    }
}
