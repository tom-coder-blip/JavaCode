package CoffeeMachine;

public class CoffeeTester {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(false, true, false); // No water

        try {
            machine.brewCoffee();
        } catch (NoWaterException e) {
            System.out.println("🚱 Error: Please refill the water tank.");
        } catch (NoBeansException e) {
            System.out.println("🌱 Error: Add coffee beans.");
        } catch (OverheatException e) {
            System.out.println("🔥 Error: Machine is overheated. Let it cool down.");
        } catch (CoffeeException e) {
            System.out.println("⚠️ General coffee error.");
        }

        System.out.println("✅ Coffee process complete.");
    }
}
