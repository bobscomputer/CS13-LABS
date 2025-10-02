/*
 *  Experimenting with comparable interface and compareTo method
 */
public class ComparableInterfaceSandbox {
    public static void main(String[] args) { 
        Car c1 = new Car("Mater");
        Car c2 = new Car("Lightning Mcqueen");
        Car c3 = new Car("Lightning Mcqueen");
        Car c4 = new Car("Zane Ninjago");

        // return 1, different object, M alphabetically after L
        System.out.printf("%nshould return 1: %20d", c1.compareTo(c2));

        // return 0, compares with itself
        System.out.printf("%nshould return 0: %20d", c1.compareTo(c1));

        // return 0, different object, same attributes
        System.out.printf("%nshould return 0: %20d", c2.compareTo(c3));

        // return -1, different object, L is alphabetically before Z
        System.out.printf("%nshould return -1: %19d", c2.compareTo(c4));
    }
}

class Car implements Comparable<Car> {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    // only one accessor because this is just an example sandbox
    public String getName() {
        return this.name;
    }


    @Override
    public int compareTo(Car o) {
        int returnValue = 0;

        // Comparing only the name of car object
        if(o instanceof Car) {
            Car c = (Car) o;

            // if name matches, return 0
            if(this.getName().equalsIgnoreCase(c.getName())) {
                returnValue = 0;
            }

            // if name does not match and is alphabetically before this object, return -1
            else if((this.getName().compareTo(c.getName())) < 0) {
                returnValue = -1;
            }
            // if name does not match and is alphabetically after this object, return 1
            else if((this.getName().compareTo(c.getName())) > 0) {
                returnValue = 1;
            }
        }
        return returnValue;
    }

}
