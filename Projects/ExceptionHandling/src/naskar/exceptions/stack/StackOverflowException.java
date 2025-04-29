package naskar.exceptions.stack;

public class StackOverflowException extends Exception{

    public StackOverflowException()
    {
        
    }
    
    public StackOverflowException(String msg)
    {
        super(msg);
    }
}
