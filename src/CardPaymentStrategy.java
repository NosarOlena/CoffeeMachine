public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        // dummy implementation for mock purposes
        System.out.println("Payment successful! (Card)");
        return true;
    }
}
