public class ExampleOfTypeCastingObjects {
}

// superclass
class Bitch {
    public void stupidSentence() {
        System.out.println("Whats updog");
    }
}

// subclass
class Beta extends Bitch {

    @Override
    public void stupidSentence() {
        System.out.println("Whats deez dude");
    }

    public void redditSentence() {
        System.out.println("Nobody understands me");
    }
}


class TypeCastingDriver {
    public static void main(String [] args) {
        Bitch b1tch = new Bitch();

        System.out.println(" === SANDBOX FOR REFERENCE TYPECASTING OBJECTS === \n");
        System.out.println("Before any reference typecasting, calling method from super/parent class:");
        b1tch.stupidSentence();             // superclass method

        Bitch bitch = new Beta();           // safe upcast, subclass to superclass
        System.out.println("\nCalling overrided superclass method from subclass:");
        bitch.stupidSentence();             // overrided superclass method
        //bitch.redditSentence();           / doesn't work because bitch variable is of Bitch type, not Beta type

        System.out.println();

        System.out.println("Downcast example. Calling unique subclass method after downcasting:");
        // downcast example
        if (bitch instanceof Beta) {        // is the obj variable a type of Beta? Beta class is a type of Bitch, bitch is of the Bitch class, so returns true
            Beta beta = (Beta) bitch;       // safe to downcast, "I promise this variable is of Beta type" therefore, it can refer to beta variable
            beta.redditSentence();
            //bitch.redditSentence();       // doesn't work because bitch variable is of Bitch type, not Beta type
        }

        System.out.println("\n===================================================");
    }
}