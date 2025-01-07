public enum CupSize {
    SMALL(1.0), MEDIUM(1.5), LARGE(2);

    private final double sizeMultiplier;

    CupSize(double sizeMultiplier) {
        this.sizeMultiplier = sizeMultiplier;
    }

    public double getSizeMultiplier() {
        return sizeMultiplier;
    }
}
