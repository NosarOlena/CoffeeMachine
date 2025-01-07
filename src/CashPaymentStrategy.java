import java.util.Scanner;

public class CashPaymentStrategy implements PaymentStrategy {
    private double cashGiven;

    @Override
    public boolean processPayment(double amount) {
        // dummy implementation for mock purposes
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of cash: ");
        cashGiven = scanner.nextDouble();

        if (cashGiven < amount) {
            System.out.println("Insufficient funds.");
            return false;
        }

        double change = cashGiven - amount;
        System.out.println("Payment successful. Change to return: " + change);
        return true;
    }

    public double getCashGiven() {
        return cashGiven;
    }
}
