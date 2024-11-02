import java.util.Scanner;


public class CheckDublicate {
    
    public static boolean checkDublicate(int ar[])
    {
        byte check[] = new byte[1000000000];
        for(int i = 0 ; i < ar.length ; i++)
        {
            int n = Math.abs(ar[i]);
            byte v = 1;
            if(ar[i] >= 0)
                v = 2;
            if(check[n] == v)
                return true;
            else
                check[n] = v;
                
            }
        return false;    



        // boolean check[] = new boolean[2 * 1000000000];
        // for(int i = 0 ; i < ar.length ; i++)
        // {
        //     int n = ar[i] + Math.abs(ar[i]);
        //     if(check[n])
        //         return true;
        //     else
        //         check[n] = true;
                
        //     }
        // return false;    



        //     for(int i = 0 ; i < ar.length - 1 ; i++)
        //         for(int j = i + 1 ; j < ar.length ; j++)
        //             if(ar[i] != ar[j])
        //                 return false;
        // return true;
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int ar[];
        ar = new int[4];
        for(int i = 0 ; i < ar.length ; i++)
            ar[i] = inp.nextInt();
        
        

        System.out.println(checkDublicate(ar));            
    }
}
