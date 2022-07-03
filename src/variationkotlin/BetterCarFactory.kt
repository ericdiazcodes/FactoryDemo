package variationkotlin

// Define an interface that declares what object it will create. Since it's
// an interface, how the Car will be created will be defined by the subclass
interface BetterCarFactory {
    fun getCar(): Car
}

// Create subclasses of the Factory that will return their own specific subclass of Car.
class HondaMotorFactory : BetterCarFactory {
    override fun getCar(): Car = Accord()
}

class BMWGroupFactory : BetterCarFactory {
    override fun getCar(): Car = BMW()
}

class FordMotorFactory : BetterCarFactory {
    override fun getCar(): Car = Mustang()
}

class GeneralMotorsFactory : BetterCarFactory {
    override fun getCar(): Car = Cadillac()
}

class AdvancedDealership : Dealership {
    private val hondaMotorFactory = HondaMotorFactory()
    private val bmwGroupFactory = BMWGroupFactory()
    private val fordMotorFactory = FordMotorFactory()
    private val generalMotorsFactory = GeneralMotorsFactory()

    override fun getCarByManufacturer(carManufacturer: CarManufacturer): Car {
        return when (carManufacturer) {
            CarManufacturer.HondaMotor -> hondaMotorFactory.getCar()
            CarManufacturer.BMWGroup -> bmwGroupFactory.getCar()
            CarManufacturer.FordMotor -> fordMotorFactory.getCar()
            CarManufacturer.GeneralMotors -> generalMotorsFactory.getCar()
        }
    }
}

fun main() {
    val advancedDealership = AdvancedDealership()

    val accord = advancedDealership.getCarByManufacturer(CarManufacturer.HondaMotor)
    val cadillac = advancedDealership.getCarByManufacturer(CarManufacturer.GeneralMotors)

    accord.drive() // prints "Driving away in a Accord"
    cadillac.drive() // prints "Driving away in a Cadillac"
}

