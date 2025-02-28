import java.util.Arrays;

public class StringBag {

    private String arr[];
    private int size;

    StringBag() {
        this(3);
    }

    StringBag(int n) {
        arr = new String[n];
        size = 0;
    }

    private void adjustCapacity() {
        if (arr.length == size) {
            String tmp[] = new String[2 * size];
            for (int i = 0; i < arr.length; i++)
                tmp[i] = arr[i];
            arr = tmp;
        }
    }

    public int capacity() {
        return arr.length;
    }

    public int size() {
        return size;
    }

    // public Bag add(String str) {
    //     return add(str, size);
    // }

    public StringBag add(String ... ar) {
        for (String string : ar) {
            add(string, size);
        }
        return this;
    }

    public StringBag add(String str, int p) {
        adjustCapacity();
        for (int i = size - 1; i >= p; i--) {
            arr[i + 1] = arr[i];
        }
        arr[p] = str;
        size++;
        return this;
    }

    private int search(String str) {
        for (int i = 0; i < size; i++) {
            if (str.equals(arr[i]))
                return i;

        }
        return -1;
    }

    public StringBag add(String what, String where) {
        int p = search(where);
        if (p >= 0)
            return add(what, p);
        return this;
    }

    public String get(int p) {
        return arr[p];
    }

    public boolean has(String str) {
        return search(str) >= 0;
    }

    public void sort() {
        Arrays.sort(arr, 0, size);
    }

    public void remove(int p) {
        for (int i = p; i < size; i++)
            arr[i] = arr[i + 1];
        size--;    
    }

    public StringBag remove(String str) {
        int p = search(str);
        if (p >= 0)
            remove(p);    
        return this;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            if (i != 0)
                sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StringBag b && size == b.size)
        {
                for(int i = 0 ; i < size ; i++)
                    if(!arr[i].equals(b.arr[i]))
                        return false;
                return true;        
        }
        else
            return false;
    }

    // Write a class named Bag which that contains a collection of strings so that
    // follow program runs successfully.

    public static void main(String agrs[]) {
        // Bag g = new Bag(3);
        // g.add("abcd").add("efgh").add("ijkl");
        // System.out.println(g);

        // g.add("mnop");
        // System.out.println(g);

        // if (true)
        //     return;

        StringBag b = new StringBag();

        // total capacity of the bag
        System.out.println(b.capacity()); // 3

        // number of elements in the bag
        System.out.println(b.size()); // 0

        b = new StringBag(5); // capacity is passed through the constructor

        // number of elements in the bag
        System.out.println(b.capacity()); // 5

        // number of elements in the bag
        System.out.println(b.size()); // 0

        b.add("Tarun"); // added a string
        b.add("Bikash").add("Ashok"); // added two strings with chain calling

        System.out.println(b); // Tarun, Bikash, Ashok

        System.out.println(b.capacity()); // 5
        System.out.println(b.size()); // 3

        b.add("Dinesh", 2); // inserted a string at position 2
        b.add("Sumit", "Bikash"); // inserted the first string at the position of the second string
        b.add("Prakash", 0); // inserted a string at the very first position

        System.out.println(b); // Prakash, Tarun, Dinesh, Sumit, Bikash, Ashok

        // since the number of elemnts exceeds the original capacity (5), the capacity
        // has been doubled
        System.out.println(b.capacity()); // 10

        // number of elements in the bag
        System.out.println(b.size()); // 6

        // element at given position
        System.out.println(b.get(2)); // Dinesh

        // checks whether the given string is existing in the bag
        System.out.println(b.has("Bikash")); // true

        b.sort();
        System.out.println(b); // Ashok, Bikash, Dinesh, Prakash, Sumit, Tarun

        // delete the element at given position
        b.remove(1);
        b.remove("Prakash").remove(0); // remove the given string and the remove element at given position by chain
                                       // calling

        System.out.println(b); // Dinesh, Sumit, Tarun
        System.out.println(b.capacity()); // 10
        System.out.println(b.size()); // 3

        b.add("Nakshatra", "Santunu", "Pronob", "Riya");
        System.out.println(b); // Dinesh, Sumit, Tarun, Nakshatra, Santunu, Pronob, Riya

    }

}
