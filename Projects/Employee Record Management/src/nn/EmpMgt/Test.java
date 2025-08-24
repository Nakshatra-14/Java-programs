package nn.EmpMgt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Date dt = new Date();
        System.out.println(dt.toString());

        String pattern = "dd/MM/yyyy";

        var sdf = new SimpleDateFormat(pattern);

        String strDt = sdf.format(dt);
        strDt += "Hello";
        String strDt2 = "12-12-2024";
        System.out.println(strDt);
        System.out.println(strDt2);

        
        System.out.println(sdf.parse(strDt));
        System.out.println(sdf.parse(strDt2));
    }
}
