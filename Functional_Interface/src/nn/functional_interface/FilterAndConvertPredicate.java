package nn.functional_interface;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterAndConvertPredicate {
    
    <E, T> ArrayList<T> filterAndConvert(ArrayList<E> list, Predicate<E> filter, Function<E, T> func)
    {
        ArrayList<T> result = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++)
        {
            E e = list.get(i);
            if(filter.test(e))
                result.add(func.apply(e));
        }
        return result;
    }
}
