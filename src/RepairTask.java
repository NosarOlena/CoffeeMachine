public class RepairTask implements MaintenanceTask {
    private String issueDescription;

    public RepairTask(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Override
    public void execute(CoffeeMachine coffeeMachine) {
        coffeeMachine.repair(issueDescription);
        System.out.println("Repaired the coffee machine. Issue: " + issueDescription);
    }
}
