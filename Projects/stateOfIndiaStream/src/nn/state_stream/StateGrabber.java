package nn.state_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateGrabber {

    private Scanner inp;
    private String prevState = "";
    private String curState = "";
    private boolean hasNextCalled;

    public StateGrabber(File file) {
        try {
            inp = new Scanner(file);
            inp.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext()
    {
        curState = grabNext();
        hasNextCalled = true;
        return curState!=null;
    }

    public String grabNext()
    {
        if(hasNextCalled)
        {
            hasNextCalled = false;
            return curState;
        }
        while(inp.hasNextLine())
        {
            String state = inp.nextLine().substring(43);
            if(!prevState.equals(state))
            {
                prevState = state;
                return state;
            }
        }
        return null;
    }

    public void close()
    {
        inp.close();
        // System.out.println("Scanner Closed");
    }
}
