public class PaperCup extends Cup {
    public PaperCup(CupSize size) {
        super(1.5, size);
    }

    @Override
    public String getType() {
        return "Paper " + getSize();
    }
}
