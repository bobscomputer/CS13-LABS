public class AbstractSandbox {
}

abstract class Bird {

    // abstract method, notice no code body
    abstract void sing();

    // concrete method
    public void fly() {
        System.out.println("Birdie is flying weeeeeeeee");
    }

    public void wings() {
        System.out.println("This bird has 2 wings");
    }

}

class DumbBird extends Bird {

    // an abstract method must be implemented or there will be an error
    // comment out the following line to see
    @Override
    public void sing() {
        System.out.println("lalalalalalalaaa");
    }

    @Override   // you can override concrete methods from the abstract class
    public void wings() {
        System.out.println("This bird has 40 wings");
    }

}

class SmartBird extends Bird {

    @Override
    public void sing() {
        System.out.println("I don't sing.");
    }
}

class Driver {
    public static void main(String[] args) {
        DumbBird dumb = new DumbBird();
        SmartBird smart = new SmartBird();
        // Bird bird = new Bird();              // notice how an error is given: can't instantiate bird

        dumb.fly();     // from abstract Bird class
        dumb.sing();    // abstract method that was implemented in child class
        smart.sing();
        dumb.wings();   // from DumbBird/child class
        smart.wings();  // from Bird/parent class
    }
}