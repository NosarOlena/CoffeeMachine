public class CashCollectionTask implements MaintenanceTask {
    @Override
    public void execute(CoffeeMachine coffeeMachine) {
        coffeeMachine.collectCash();
    }
}

