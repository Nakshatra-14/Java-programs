public class ArrayReverse {
    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int e : ar) {                       //Print the Array
            System.out.print(e + " ");
        }

        System.out.println(); 

        for(int i = ar.length - 1; i >= 0 ; i--)    //Reverse element of Array
            System.out.print(ar[i] + " ");

        System.out.println();
        
        int f = 0, l = ar.length - 1;
        while(f < l)
        {
            //swap ar[f], ar[l]
            int t = ar[f];
            ar[f] = ar[l];
            ar[l] = t;
            f++;
            l--; 
        }
        for(int e : ar)
            System.out.print(e + " ");
        System.out.println();    
    }
}
