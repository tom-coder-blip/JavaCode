package Prac73;

class Cat {
    private double height;
    private String name;

    public void setHeight(double h){
        height = h;
    }

    public void setName(String n){
        name = n;
    }

    public double getHeight(){
        return height;
    }

    public String getName(){
        return name;
    }
}

class HeightCalculator {
    double h1;
    double h2;

    public double addHeights() {
        double total = h1 + h2;
        return total;
    }
}

class Checker {
    public String checkHeight(double h) {
        if (h > 20.0) {
            return "Tall cat!";
        }else{
            return "Still growing...";
        }
    }
}

public class TestCats {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        c1.setName("Whiskers");
        c1.setHeight(18.5);

        Cat c2 = new Cat();
        c2.setName("Shadow");
        c2.setHeight(22.0);

        HeightCalculator calc = new HeightCalculator();
        calc.h1 = c1.getHeight();
        calc.h2 = c2.getHeight();

        double combined = calc.addHeights();
        System.out.println("Combined height: " + combined);

        Checker checker = new Checker();
        System.out.println(c1.getName() + ": " + checker.checkHeight(c1.getHeight()));
        System.out.println(c2.getName() + ": " + checker.checkHeight(c2.getHeight()));
    }
}

