public class Cream extends AddOn{

    public Cream(Beverage beverage) {
        super(beverage);
    }

    @Override
    protected String getAddOnDescription() {
        return "Cream";
    }

    @Override
    protected double getAddOnCost() {
        return 0.60;
    }
}
