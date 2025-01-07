public class PlasticCup extends Cup {
    public PlasticCup(CupSize size) {
        super(1.0, size);
    }

    @Override
    public String getType() {
        return "Plastic " + getSize();
    }
}
