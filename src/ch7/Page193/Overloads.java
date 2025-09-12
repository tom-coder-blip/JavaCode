package ch7.Page193;

public class Overloads {
    String uniqueID;

    // Overloaded method 1
    int addNums(int a, int b) {
        return a + b;
    }

    // Overloaded method 2
    double addNums(double a, double b) {
        return a + b;
    }

    // Overloaded method 3
    public void setUniqueID(String theID) {
        // lots of validation code, and then:
        uniqueID = theID;
    }

    // Overloaded method 4
    public void setUniqueID(int ssNumber) {
        String numString = "" + ssNumber;
        setUniqueID(numString);
    }

    // method to retrieve uniqueID
    public String getUniqueID() {
        return uniqueID;
    }
}
