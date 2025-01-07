import java.util.*;
import java.util.function.Function;

public class BeverageFactory {

    private static final Map<String, Function<CupSize, Cup>> CUP_CREATORS = new HashMap<>();
    private static final Map<String, Function<Beverage, AddOn>> ADD_ON_CREATORS = new HashMap<>();

    static {
        CUP_CREATORS.put("Paper", PaperCup::new);
        CUP_CREATORS.put("Plastic", PlasticCup::new);

        ADD_ON_CREATORS.put("Milk", Milk::new);
        ADD_ON_CREATORS.put("Sugar", Sugar::new);
        ADD_ON_CREATORS.put("Cream", Cream::new);
    }

    public static Beverage createBeverage(String type, Cup cup) {
        return switch (type) {
            case "Espresso" -> new Espresso(cup);
            case "Cappuccino" -> new Cappuccino(cup);
            case "Latte" -> new Latte(cup);
            default -> throw new IllegalArgumentException("Unknown beverage type: " + type);
        };
    }

    public static Cup createCup(String cupType, CupSize cupSize) {
        Function<CupSize, Cup> cupCreator = CUP_CREATORS.get(cupType);
        if (cupCreator == null) {
            throw new IllegalArgumentException("Invalid cup type: " + cupType);
        }
        return cupCreator.apply(cupSize);
    }

    public static Beverage createAddOn(Beverage beverage, String addOn) {
        Function<Beverage, AddOn> addOnCreator = ADD_ON_CREATORS.get(addOn);
        if (addOnCreator == null) {
            throw new IllegalArgumentException("Invalid add-on: " + addOn);
        }
        return addOnCreator.apply(beverage);
    }
}
