package nn.billmgt;

public class Test {

    // public static boolean isPalindrome(String s) {
    //     int len = s.length();
    //     int f = 0;
    //     int l = len - 1;
    //     while(f < l)
    //     {
    //         while(f < len && !Character.isAlphabetic(s.charAt(f)))
    //             f++;
    //         while(l >= 0 && !Character.isAlphabetic(s.charAt(l)))
    //             l--;
    //         if(!(f < len && l >= 0 && Character.toLowerCase(s.charAt(f)) == Character.toLowerCase(s.charAt(l))))
    //             return false;
    //         f++;
    //         l--;
    //     }
    //     return true;
    // }
    private static PaymentService paymentService;

    public static void setPaymentService(PaymentService paymentService) {
        Test.paymentService = paymentService;
    }
    // public Test() {
    //     this.paymentService = new GooglePayPaymentService();
    // }

    

    public static void main(String[] args) {
        // System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        // System.out.println("()".contains("()"));
        // System.out.println("(())".contains("()"));
        // System.out.println("())".contains("()"));
        // System.out.println("(())".contains("()"));
        // System.out.println("((())".contains("()"));

        // String name = "Nax";

        // if(!name.isEmpty())
        //     System.out.println(name);
        // else
        //     System.out.println("Hello");
        setPaymentService(new PhonePePaymentService());
        paymentService.doPayment(100);
    }
}
