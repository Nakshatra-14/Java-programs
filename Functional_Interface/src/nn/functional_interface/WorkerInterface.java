package nn.functional_interface;

interface Worker 
{
    // void do();
    void doWork();
}


public class WorkerInterface {

    static <T> void arrayPrint(T arr[], Worker worker)
    {
        for(var e : arr)
        {
            System.out.println(e);
            worker.doWork();
        }
    }

    public static void main(String[] args) {
        String name[] = {"Amy", "John", "Elizabeth", "Maxwell"};
        arrayPrint(name, () -> System.out.println("Bye"));
    }
}
