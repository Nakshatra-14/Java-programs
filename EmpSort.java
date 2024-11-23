import java.util.*;

class Emp {

    private String name ;
    private int age ;
    private float sal ;

    Emp()
    {
        name = "<noname>";
        age = 18;
        sal = 10000;
    }

    public Emp(String name, int age, float sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public String getName() 
        {   return name ; }

    public int getAge()
        {   return age ;  } 
        
    public float getSal()
        {   return sal;   } 
        
}

public class EmpSort {

    public static void specialEmpSort(Emp ar[])
    {
        int n = ar.length;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            
            for(int j = i + 1 ; j < n ; j++)
            {
                if(ar[i] == ar[j])
                {
                    //swap ar[i], ar[j]
                    Emp temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Emp e[] = new Emp[6];

        for (int i = 0 ; i < e.length ; i++) {
            e[i] = new Emp();
        }

        e[0] = new Emp("Alice", 25, 30000);
        e[1] = new Emp("Neela", 30, 35000);
        e[2] = new Emp("Rakesh", 28, 32000);
        e[3] = new Emp("Mukesh", 35, 40000);

        
        // specialEmpSort(e);

        Arrays.sort(e);
        for (Emp emp : e) {
            System.out.println(emp.getName() + ", " + emp.getAge() + ", " + emp.getSal());
        }
    }
}
