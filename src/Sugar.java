public class Sugar extends AddOn {

    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    protected String getAddOnDescription() {
        return "Sugar";
    }

    @Override
    protected double getAddOnCost() {
        return 0.30;
    }
}
