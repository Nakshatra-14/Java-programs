package nn.billmgt;

public class GooglePayPaymentService implements PaymentService{

    @Override
    public void doPayment(int amount) {
        System.out.println("GooglePay");
        System.out.println("payment of Amt: " + amount);
    }

}
