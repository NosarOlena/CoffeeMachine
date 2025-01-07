import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Map<CupSize, Integer>> cupStock;
    private Map<String, Integer> beverageStock;
    private Map<String, Integer> addOnStock;

    public Inventory() {
        cupStock = new HashMap<>();
        beverageStock = new HashMap<>();
        addOnStock = new HashMap<>();

        for (String cupType : Constants.CUP_TYPES) {
            Map<CupSize, Integer> sizeMap = new HashMap<>();
            for (CupSize size : CupSize.values()) {
                sizeMap.put(size, 0);
            }
            cupStock.put(cupType + " Cup", sizeMap);
        }

        for (String beverage : Constants.BEVERAGES) {
            beverageStock.put(beverage, 0);
        }

        for (String addOn : Constants.ADD_ONS) {
            addOnStock.put(addOn, 0);
        }

    }

    public boolean updateCupStock(String cupType, CupSize size, int quantity) {
        Map<CupSize, Integer> stockMap = cupStock.get(cupType + " Cup");
        if (stockMap == null || !stockMap.containsKey(size)) {
            System.out.println("Item not found in inventory: " + cupType + " " + size);
            return false;
        }

        int currentQuantity = stockMap.getOrDefault(size, 0);
        int newQuantity = currentQuantity + quantity;

        if (newQuantity < 0) {
            System.out.println("Insufficient stock for item: " + cupType + " " + size);
            return false;
        }

        stockMap.put(size, newQuantity);
        return true;
    }

    public boolean updateBeverageStock(String beverageName, int quantity) {
        int currentQuantity = beverageStock.getOrDefault(beverageName, 0);
        int newQuantity = currentQuantity + quantity;

        if (newQuantity < 0) {
            System.out.println("Insufficient stock for beverage: " + beverageName);
            return false;
        }

        beverageStock.put(beverageName, newQuantity);
        return true;
    }

    public boolean updateAddOnStock(String addOnName, int quantity) {
        int currentQuantity = addOnStock.getOrDefault(addOnName, 0);
        int newQuantity = currentQuantity + quantity;

        if (newQuantity < 0) {
            System.out.println("Insufficient stock for add-on: " + addOnName);
            return false;
        }

        addOnStock.put(addOnName, newQuantity);
        return true;
    }

    public boolean isCupAvailable(String cupType, CupSize size) {
        Map<CupSize, Integer> stockMap = cupStock.get(cupType + " Cup");
        if (stockMap == null || !stockMap.containsKey(size)) {
            return false;
        }

        return stockMap.get(size) > 0;
    }

    public boolean isBeverageAvailable(String beverageName) {
        return beverageStock.getOrDefault(beverageName, 0) > 0;
    }

    public boolean isAddOnAvailable(String addOnName) {
        return addOnStock.getOrDefault(addOnName, 0) > 0;
    }

    public void displayAvailableItems() {
        System.out.println("Available Cups:");
        for (Map.Entry<String, Map<CupSize, Integer>> entry : cupStock.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<CupSize, Integer> sizeEntry : entry.getValue().entrySet()) {
                System.out.println("  " + sizeEntry.getKey() + " - " + sizeEntry.getValue());
            }
        }

        System.out.println("\nAvailable Beverages:");
        for (Map.Entry<String, Integer> entry : beverageStock.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\nAvailable Add-ons:");
        for (Map.Entry<String, Integer> entry : addOnStock.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
