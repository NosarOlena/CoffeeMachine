import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    private Inventory inventory;
    private PaymentStrategy paymentStrategy;
    private double cashCollected;

    public CoffeeMachine() {
        this.inventory = new Inventory();
        this.cashCollected = 0.0;
    }

    public void displayMenu() {
        inventory.displayAvailableItems();
    }

    public Beverage dispenseBeverage(String beverageName, String cupType, CupSize cupSize, List<String> addOns) {
        if (!checkAvailability(beverageName, cupType, cupSize, addOns)) {
            return null;
        }

        Beverage beverage = prepareBeverage(beverageName, cupType, cupSize, addOns);
        updateInventory(beverageName, cupType, cupSize, addOns);

        if (choosePaymentMethod(beverage.getCost())) {
            System.out.println("Here is your " + beverage.getDescription());
            return beverage;
        } else {
            System.out.println("Payment failed. Beverage not dispensed.");
            return null;
        }
    }

    private boolean choosePaymentMethod(double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter payment method (cash/card): ");
        String paymentMethod = scanner.nextLine().trim().toLowerCase();

        if (paymentMethod.equals("cash")) {
            paymentStrategy = new CashPaymentStrategy();
            if (paymentStrategy.processPayment(price)) {
                double cashGiven = ((CashPaymentStrategy) paymentStrategy).getCashGiven();
                cashCollected += cashGiven;
                System.out.println("Payment received: " + cashGiven);
                return true;
            } else {
                System.out.println("Insufficient cash.");
                return false;
            }
        } else if (paymentMethod.equals("card")) {
            paymentStrategy = new CardPaymentStrategy();
            if (paymentStrategy.processPayment(price)) {
                return true;
            } else {
                System.out.println("Card payment failed.");
                return false;
            }
        } else {
            System.out.println("Invalid payment method.");
            return false;
        }
    }

    private boolean checkAvailability(String beverageName, String cupType, CupSize cupSize, List<String> addOns) {
        if (!inventory.isBeverageAvailable(beverageName)) {
            System.out.println("The selected beverage is not available.");
            return false;
        }

        if (!inventory.isCupAvailable(cupType, cupSize)) {
            System.out.println("The selected cup size is unavailable.");
            return false;
        }

        for (String addOn : addOns) {
            if (!inventory.isAddOnAvailable(addOn)) {
                System.out.println("The selected add-on " + addOn + " is unavailable.");
                return false;
            }
        }

        return true;
    }

    private Beverage prepareBeverage(String beverageName, String cupType, CupSize cupSize, List<String> addOns) {
        Cup cup = BeverageFactory.createCup(cupType, cupSize);
        Beverage beverage = BeverageFactory.createBeverage(beverageName, cup);

        for (String addOn : addOns) {
            beverage = BeverageFactory.createAddOn(beverage, addOn);
        }
        return beverage;
    }

    private void updateInventory(String beverageName, String cupType, CupSize cupSize, List<String> addOns) {
        inventory.updateBeverageStock(beverageName, -1);
        inventory.updateCupStock(cupType, cupSize, -1);
        for (String addOn : addOns) {
            inventory.updateAddOnStock(addOn, -1);
        }
    }

    public void refill(String item, int quantity) {
        if (item.contains("Cup")) {
            String cupType = item.replace(" Cup", "");
            CupSize[] cupSizes = CupSize.values();

            for (CupSize size : cupSizes) {
                boolean success = inventory.updateCupStock(cupType, size, quantity);
                if (success) {
                    System.out.println("Refilled " + quantity + " " + cupType + " cups of size " + size);
                }
            }
        } else if (Arrays.asList(Constants.BEVERAGES).contains(item)) {
            boolean success = inventory.updateBeverageStock(item, quantity);
            if (success) {
                System.out.println("Refilled " + quantity + " units of beverage: " + item);
            }
        } else if (Arrays.asList(Constants.ADD_ONS).contains(item)) {
            boolean success = inventory.updateAddOnStock(item, quantity);
            if (success) {
                System.out.println("Refilled " + quantity + " units of add-on: " + item);
            }
        } else {
            System.out.println("Invalid item to refill: " + item);
        }
    }

    public void collectCash() {
        System.out.println("Collecting cash: " + cashCollected);
        cashCollected = 0.0;
    }

    public void repair(String issueDescription) {
        System.out.println("Performing repair: " + issueDescription);
    }
}
