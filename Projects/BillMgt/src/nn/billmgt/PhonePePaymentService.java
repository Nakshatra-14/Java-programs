package nn.billmgt;

public class PhonePePaymentService implements PaymentService{

    @Override
    public void doPayment(int amount) {
        System.out.println("PhonePe");
        System.out.println("payment of Amt: " + amount);
    }

}
