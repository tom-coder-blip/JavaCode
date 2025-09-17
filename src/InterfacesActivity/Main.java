package InterfacesActivity;

public class Main {
    public static void main(String[] args) {
        Animal[] zooAnimals = {
                new Dog(),
                new Lion(),
                new Parrot()
        };

        ZooReport report = new ZooReport(zooAnimals);
        report.generateReport();
    }
}
