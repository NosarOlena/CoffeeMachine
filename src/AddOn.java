public abstract class AddOn extends Beverage {
    protected Beverage beverage;

    public AddOn(Beverage beverage) {
        super(beverage.getCup());
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + getAddOnDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost() + getAddOnCost();
    }

    protected abstract String getAddOnDescription();
    protected abstract double getAddOnCost();
}
