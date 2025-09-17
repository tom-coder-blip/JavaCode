package InterfacesActivity;

public abstract class Report {
    public void printHeader() {
        System.out.println("=== Animal Behavior Report ===");
    }

    public abstract void generateReport();
}