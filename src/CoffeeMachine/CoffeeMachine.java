package CoffeeMachine;

class CoffeeMachine {
    boolean hasWater;
    boolean hasBeans;
    boolean isOverheated;

    CoffeeMachine(boolean hasWater, boolean hasBeans, boolean isOverheated) {
        this.hasWater = hasWater;
        this.hasBeans = hasBeans;
        this.isOverheated = isOverheated;
    }

    void brewCoffee() throws NoWaterException, NoBeansException, OverheatException {
        if (!hasWater) {
            throw new NoWaterException();
        }
        if (!hasBeans) {
            throw new NoBeansException();
        }
        if (isOverheated) {
            throw new OverheatException();
        }

        System.out.println("☕ Coffee brewed successfully!");
    }
}
