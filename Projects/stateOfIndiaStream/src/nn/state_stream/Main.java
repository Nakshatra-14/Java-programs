package nn.state_stream;

import java.io.File;
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
    // public String getNextState(Scanner inp, String prevState)
    // {
    // inp.nextLine();
    // while(inp.hasNextLine())
    // {
    //     String state = inp.nextLine().substring(43);
    //     if(prevState.equals(state))
    //         while(inp.hasNextLine())
    //         {
    //             state = inp.nextLine().substring(43);
    //             if(!prevState.equals(state))
    //             {
    //                 sta = state;
    //                 return state;
    //             }
    //         }
    // }
    // return null;
    // }
    public static Stream<String> stateStream() {
        StateGrabber sg = new StateGrabber(new File("StatewiseCitiesOfIndia.txt"));
        Stream<String> stm = Stream.iterate(sg.grabNext(), _ -> sg.hasNext(), _ -> sg.grabNext());
        stm = stm.onClose(sg::close);
        return stm;
    }

    Main() {
        Stream<String> stm = stateStream();
        stm = stm.limit(5);
        System.out.println("Printing the States");
        stm.forEach(System.out::println);
        stm.close();
        // System.out.println(getNextState("Bihar"));
    }

    public static void main(String[] args) {
        new Main();
    }
}
