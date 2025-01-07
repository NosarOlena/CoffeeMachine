public class RefillTask implements MaintenanceTask {
    private String item;
    private int quantity;

    public RefillTask(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public void execute(CoffeeMachine coffeeMachine) {
        coffeeMachine.refill(item, quantity);
    }
}
