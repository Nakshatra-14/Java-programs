package nn.functional_interface;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DoForSelectedConsumer {
    <T> void DoForSelected(ArrayList<T> ar, Predicate<T> cond, Consumer<T> job)
    {
        for(T e : ar)
            if(cond.test(e))
                job.accept(e);
    }
}
