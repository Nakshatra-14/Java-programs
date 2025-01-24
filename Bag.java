public class Bag {
    
    private String arr[];
    private int size;

    Bag()
    {
        this(3);
    }

    Bag(int n)
    {
        arr = new String[n];
        size = 0;
    }

    public int capacity()
    {
        return arr.length;
    }

    public int size()
    {
        return size;
    }

    public Bag add(String str)
    {
        return this;
    }

    public Bag add(String str, int n)
    {
        return this;
    }

    public Bag add(String where, String what)
    {
        return this;
    }

    public String get(int n)
    {
        return "H";
    }

    public boolean has(String str)
    {
        return false;
    }

    public void sort()
    {

    }

    public Bag remove(int n)
    {
        return this;
    }

    public Bag remove(String str)
    {
        return this;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0 ; i < size ; i++)
            s += arr[i] + ", ";
        return s;    
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Write a class named Bag which that contains a collection of strings so that follow program runs successfully.

    public static void main(String agrs[])
    {
        Bag b = new Bag() ;

        // total capacity of the bag
        System.out.println(b.capacity()) ; // 3

        // number of elements in the bag
        System.out.println(b.size()) ; // 0 

        b = new Bag(5) ; // capacity is passed through the constructor

        // number of elements in the bag
        System.out.println(b.capacity()) ; // 5

        // number of elements in the bag
        System.out.println(b.size()) ; // 0

        b.add("Tarun") ;   // added a string    
        b.add("Bikash").add("Ashok") ; // added two strings with chain calling

        System.out.println(b) ; // Tarun, Bikash, Ashok

        if(true)
            return;

        System.out.println(b.capacity()) ; // 5
        System.out.println(b.size()) ; // 3

        b.add("Dinesh", 2) ;   // inserted a string at position 2
        b.add("Sumit", "Bikash") ;  // inserted the first string at the position of the second string
        b.add("Prakash", 0) ;  // inserted a string at the very first position 
        
        System.out.println(b) ; // Prakash, Tarun, Dinesh, Sumit, Bikash, Ashok
        
        // since the number of elemnts exceeds the original capacity (5), the capacity has been doubled
        System.out.println(b.capacity()) ; // 10

        // number of elements in the bag
        System.out.println(b.size()) ; // 6

        // element at given position
        System.out.println(b.get(2)) ; // Dinesh

        // checks whether the given string is existing in the bag
        System.out.println(b.has("Bikash")) ; // true

        b.sort() ;
        System.out.println(b) ; // Ashok, Bikash, Dinesh, Prakash, Sumit, Tarun

        // delete the element at given position
        b.remove(1) ;
        b.remove("Prakash").remove(0) ;  // remove the given string and the remove element at given position by chain calling

        System.out.println(b) ; // Dinesh, Sumit, Tarun
        System.out.println(b.capacity()) ; // 10
        System.out.println(b.size()) ; // 3

        // b.add("Nakshatra", "Santunu", "Pronob", "Riya");
        // System.out.println(b);  // Dinesh, Sumit, Tarun, Nakshatra, Santunu, Pronob, Riya
    }

    
}


