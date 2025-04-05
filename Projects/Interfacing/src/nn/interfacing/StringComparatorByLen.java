package nn.interfacing;

import java.util.Comparator;

public class StringComparatorByLen implements Comparator{

    @Override
    public int compare(Object a, Object b) {
        if(a instanceof String p && b instanceof String q)
            return p.length() - q.length();
        else
            return 0;    
    }
    
}
