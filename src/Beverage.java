public abstract class Beverage {
    private String description = "Unknown Beverage";
    private double cost = 0.0;
    private Cup cup;

    public Beverage(Cup cup) {
        this.cup = cup;
    }

    public String getDescription() {
        return description + " in a " + cup.getType() + " cup";
    }

    public double getCost() {
        return cost * cup.getSize().getSizeMultiplier() + cup.getPrice();
    }

    protected Cup getCup() {
        return cup;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setCost(double cost) {
        this.cost = cost;
    }
}
