package Vehicle_Inheritance;

public class VehicleOwner {
    public void start() {
        Mechanic mechanic = new Mechanic();

        Car car = new Car();
        Bike bike = new Bike();
        Truck truck = new Truck();
        Airplane airplane = new Airplane();

        mechanic.testDrive(car);      // Car’s version of methods runs
        mechanic.testDrive(bike);     // Bike’s version runs
        mechanic.testDrive(truck);    // Truck’s version runs
        mechanic.testDrive(airplane); // Airplane’s version runs

        // Call each vehicle's unique method
        car.honk();
        bike.ringBell();
        truck.loadCargo();
        airplane.deployLandingGear();
    }

    public static void main(String[] args) {
        VehicleOwner owner = new VehicleOwner();
        owner.start();
    }

}
