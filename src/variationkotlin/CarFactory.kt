package variationkotlin

// Create a class that will contain a function that returns a particular type.
// The naming will be "*type*Factory
class CarFactory {

    // Create a function that will return the type but will contain
    // the details of which subclass of that type is desired based on
    // some evaluation, in this case, with will be based on car manufacturer.
    fun getCarByManufacturer(carManufacturer: CarManufacturer): Car {
        return when (carManufacturer) {
            CarManufacturer.HondaMotor -> Accord()
            CarManufacturer.BMWGroup -> BMW()
            CarManufacturer.FordMotor -> Mustang()
            CarManufacturer.GeneralMotors -> Cadillac()
        }
    }
}

// Create superclass of the desired object. This is not limited to interfaces.
// Then create some subclasses of the superclass.
interface Car {
    fun drive() {
        println("Driving away in a $this)")
    }
}

class Accord : Car
class Cadillac : Car
class Mustang : Car
class BMW : Car

// For this example, we are shopping for a Car based on the CarManufacturer
sealed class CarManufacturer {
    object HondaMotor : CarManufacturer()
    object BMWGroup : CarManufacturer()
    object FordMotor : CarManufacturer()
    object GeneralMotors : CarManufacturer()
}

class BasicDealership : Dealership {
    private val carFactory = CarFactory()

    override fun getCarByManufacturer(carManufacturer: CarManufacturer): Car =
        carFactory.getCarByManufacturer(carManufacturer)
}

fun main() {
    val basicDealership = BasicDealership()

    val accord = basicDealership.getCarByManufacturer(CarManufacturer.HondaMotor)
    val cadillac = basicDealership.getCarByManufacturer(CarManufacturer.GeneralMotors)

    accord.drive() // prints "Driving away in a Accord"
    cadillac.drive() // prints "Driving away in a Cadillac"
}