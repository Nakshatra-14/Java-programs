public class VaidFloatChecker {

    public static boolean isValidFloat(String str)
    {
        int p = 0;
        for(int i = 0 ; i < str.length() ; i++)
        {
            // if(str.charAt(i) == )
            // if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
            //     return false;

            if(Character.isAlphabetic(str.charAt(i)))
                return false;

            if(str.charAt(i) == '.')
                p++;
        }
        if(p == 1)
            return true;
        else
            return false;    
    }
    
    public static void main(String[] args) {
        String str1 = "6.25";
        String str2 = "989.25.2";
        String str3 = "abc.d";
        System.out.println(str1);
        System.out.println(isValidFloat(str1));
        System.out.println(str2);
        System.out.println(isValidFloat(str2));
        System.out.println(str3);
        System.out.println(isValidFloat(str3));
    }
}
