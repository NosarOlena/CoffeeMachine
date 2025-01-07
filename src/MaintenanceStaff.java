public class MaintenanceStaff {
    private String id;
    private String name;
    private String authCode;

    public MaintenanceStaff(String id, String name, String authCode) {
        this.id = id;
        this.name = name;
        this.authCode = authCode;
    }

    public boolean authorize(String inputAuthCode) {
        return this.authCode.equals(inputAuthCode);
    }

    public void performMaintenance(CoffeeMachine coffeeMachine, MaintenanceTask task) {
        task.execute(coffeeMachine);
    }
}
