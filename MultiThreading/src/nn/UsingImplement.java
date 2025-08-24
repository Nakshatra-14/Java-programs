package nn;

class Assistant implements Runnable
{
    @Override
    public void run() {
        //This is the task the assistant will perform
    }

}

public class UsingImplement {
    public static void main(String[] args) {
        Assistant task = new Assistant();
        Thread a = new Thread(task);
        a.start();
    }
}
