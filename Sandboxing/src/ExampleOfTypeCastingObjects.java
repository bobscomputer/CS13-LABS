public class ExampleOfTypeCastingObjects {
}

// superclass
class Dog {
    public void speak1() {
        System.out.println("Whats updog");
    }
}

// subclass
class Puppy extends Dog {

    @Override
    public void speak1() {
        System.out.println("Whats pup dude");
    }

    public void speak2() {
        System.out.println("arf!");
    }
}


class TypeCastingDriver {
    public static void main(String [] args) {
        //Dog b1 = new Dog();
        //((Puppy)b1).speak1();       // notice how you can't directly downcast from a Parent to a child class
       
        Dog dog1 = new Dog();

        System.out.println(" === SANDBOX FOR REFERENCE TYPECASTING OBJECTS === \n");
        System.out.println("Before any reference typecasting, calling method from super/parent class:");
        dog1.speak1();                  // superclass method

        Dog dog = new Puppy();          // safe upcast, subclass to superclass
        System.out.println("\nCalling overrided superclass method from subclass:");
        dog.speak1();                   // overrided superclass method
        //Dog.speak2();                 // doesn't work because Dog variable is of Dog type, not Puppy type

        System.out.println();

        System.out.println("Downcast example. Calling unique subclass method after downcasting:");
        // downcast example
        if (dog instanceof Puppy) {        // is the obj variable a type of Puppy? Puppy class is a type of Dog, Dog is of the Dog class, so returns true
            Puppy Puppy = (Puppy) dog;     // safe to downcast, "I promise this variable is of Puppy type" therefore, it can refer to Puppy variable
            Puppy.speak2();
            //Dog.speak2();                // doesn't work because Dog variable is of Dog type, not Puppy type
        }

        System.out.println("\n===================================================");
    }
}