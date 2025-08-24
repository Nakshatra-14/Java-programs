package nn;

class Assistant extends Thread
{
    //This is the task the assistant will perform

    public void run()
    {
        //time consuming task here
    }
}

public class UsingExtends {
    public static void main(String[] args) {
        Assistant a = new Assistant();
        a.start();
    }
}
