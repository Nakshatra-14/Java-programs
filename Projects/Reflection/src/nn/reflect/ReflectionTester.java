// input name of class and print its details
package nn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTester 
{
    public static void main(String[] args) throws ClassNotFoundException 
    {
        
        String className = "Emp" ;
        String str = "abcd" ;

        Class cl = Class.forName(className) ;


        // System.out.println(cl.getName()); // Emp

        // cl = str.getClass() ;
        // System.out.println(str.getClass()); // class java.lang.Stirng

        String qualifier = "class" ;

        if(cl.isEnum())
            qualifier = "enum";
        else if(cl.isRecord())
            qualifier = "record";
        else if(cl.isInterface())
            qualifier = "interface";

        System.out.println(qualifier + " " + cl.getName());

        System.out.println("it a subclass of " + cl.getSuperclass().getName());

        System.out.println("Fields:");
        Field flds[] = cl.getFields() ;
        for (Field f : flds)
            System.out.println("\t" + f);

        System.out.println("Methods:");
        Method meths[] = cl.getMethods() ;
        for (Method m : meths)
            System.out.println("\t" + m);
    }    
}
