package com.example.nn;

import java.util.ArrayList;

public class CSV {
    private String sep ;
    private char quot ;

    public CSV()
    {
        this(",") ;
    }

    public CSV(String sep)
    {
        this(sep, '\"') ;
    }

    public CSV(String sep, char quot)
    {
        this.sep = sep ;
        this.quot = quot ;
    }

    // Extract csv fields from a line
    public String[] extract(String line) throws RuntimeException
    {
        ArrayList<String> lst = new ArrayList<>() ;
        int p = 0, q = 0 ;

        while(p < line.length())
        {
            if(line.charAt(p) == quot)
            {
                p ++ ;
                q = line.indexOf(quot, p) ;
                if(q == -1)
                    throw new RuntimeException("Quotation required after position " + p) ;

                lst.add(line.substring(p, q)) ;
                p = q + 2 ; // also skip the comma after it
            }
            else
            {
                q = line.indexOf(sep, p) ;
                if(q == -1)
                    q = line.length() ;

                lst.add(line.substring(p, q)) ;
                p = q + 1 ;
            }

        }


        String ar[] = new String[lst.size()] ;

        // int i = 0 ;
        // for (String str : lst) 
        //     ar[i++] = str ;
        // return ar ;

        return (String[]) lst.toArray(ar) ;
    }


    public static void main(String[] args) {
        // String line = "2,10dAcafEBbA5FcA,Kristina,Ferrell,\"Horn, Shepard and Watson\",Aaronville,Andorra,932-062-1802,(209)172-7124x3651,xreese@hall-donovan.com,2020-04-27,https://tyler-pugh.info/" ;
        String line = "46,Suresh Paul,21/25/1998,http://drsuresh.com,\"M.B.B.S, F.R.C.S, P.G.D.C.\",sureshpaul@gmail.com" ;
        CSV csv = new CSV() ;
        String fields[] = csv.extract(line) ;

        for (String fld : fields)
            System.out.println(fld);


    }

/*
46
Suresh Paul
21/25/1998
http://drsuresh.com
M.B.B.S, F.R.C.S, P.G.D.C.
sureshpaul@gmail.com
 */

}
