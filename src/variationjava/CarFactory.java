package variationjava;

// Create a class that will contain a function that returns a particular type.
// The naming will be "*type*Factory
class CarFactory {

    Car getCarByManufacturer(CarManufacturer carManufacturer) {
        if (carManufacturer instanceof HondaMotor) {
            return new Accord();
        } else if (carManufacturer instanceof BMWGroup) {
            return new BMW();
        } else if (carManufacturer instanceof FordMotor) {
            return new Mustang();
        } else if (carManufacturer instanceof GeneralMotors) {
            return new Cadillac();
        } else {
            throw new IllegalArgumentException("We don't have that Car here");
        }
    }
}
