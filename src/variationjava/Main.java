package variationjava;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car bmw = carFactory.getCarByManufacturer(new BMWGroup());
        Car mustang = carFactory.getCarByManufacturer(new FordMotor());

        bmw.drive(); // prints "Driving away in a BMW"
        mustang.drive(); // prints "Driving away in a Mustang"
    }
}
