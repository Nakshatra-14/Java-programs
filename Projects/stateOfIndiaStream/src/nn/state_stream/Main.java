package nn.state_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    // public Stream<String> stateStream()
    // {
    //     List<String> lst = new ArrayList<>();
    //     try
    //     (
    //         Scanner inp = new Scanner(new File("StatewiseCitiesOfIndia.txt"));
    //     )
    //     {
    //         inp.nextLine();
    //         while(inp.hasNextLine())
    //         {
    //             String state = inp.nextLine().substring(43);
    //             if(!lst.contains(state))
    //                 lst.add(state);
    //         }
    //     } catch (FileNotFoundException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     // System.out.println(lst);
    //     return lst.stream();
    // }

    private String sta = "";
    public Stream<String> stateStream()
    {
        try
        (
            Scanner inp = new Scanner(new File("StatewiseCitiesOfIndia.txt"));
        )
        {
            Stream<String> stm Stream.iterate("Andaman and Nicobar Islands", inp.hasNextLine(), getNextState(inp, sta));

            stm.onClose(() -> {
                inp.close();
            });
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public String getNextState(Scanner inp, String prevState)
    {
    
        inp.nextLine();
        while(inp.hasNextLine())
        {
            String state = inp.nextLine().substring(43);
            if(prevState.equals(state))
                while(inp.hasNextLine())
                {
                    state = inp.nextLine().substring(43);
                    if(!prevState.equals(state))
                    {
                        sta = state;
                        return state;
                    }
                }
        }
        return null;
    }

   Main()
   {
        // Stream <String> stm = stateStream();
        // stm = stm.limit(5);
        // stm.forEach(System.out::println);

        System.out.println(getNextState("Bihar"));
   }

   public static void main(String[] args) {
    new Main();
   }
}
