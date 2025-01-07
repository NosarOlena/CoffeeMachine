public class Milk extends AddOn {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    protected String getAddOnDescription() {
        return "Milk";
    }

    @Override
    protected double getAddOnCost() {
        return 0.50;
    }
}
