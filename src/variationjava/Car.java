package variationjava;

// Create superclass of the desired object. This is not limited to interfaces.
// Then create some subclasses of the superclass.
abstract class Car {
    void drive() {
        System.out.println("Driving away in a ".concat(this.toString()));
    }
}

class Accord extends Car {
}

class Cadillac extends Car {
}

class Mustang extends Car {
}

class BMW extends Car {
}
