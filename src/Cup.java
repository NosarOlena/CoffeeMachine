public abstract class Cup {
    private double price;
    private CupSize size;

    public Cup(double price, CupSize size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public CupSize getSize() {
        return size;
    }

    public abstract String getType();
}
