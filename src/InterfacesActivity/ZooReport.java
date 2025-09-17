package InterfacesActivity;

public class ZooReport extends Report {
    private Animal[] animals;

    public ZooReport(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public void generateReport() {
        printHeader();
        for (Animal a : animals) {
            a.roam();
            a.makeSound();

            if (a instanceof Pet) {
                Pet p = (Pet) a;
                p.beFriendly();
                p.play();
            }

            System.out.println("---");
        }
    }
}
