package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDriversOptimal(): Set<Driver> =
    this.allDrivers - this.trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengersOptimal(minTrips: Int): Set<Passenger> =
    this.trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= minTrips }
        .keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengersOptimal(driver: Driver): Set<Passenger> =
    this.trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengersOptimal(): Set<Passenger> =
    this.allPassengers
        .associateWith { passenger ->
            this.trips.filter { passenger in it.passengers }
        }.filterValues { group ->
            val (withDiscount, withoutDiscount) = group.partition { it.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriodOptimal(): IntRange? {
    return this.trips
        .groupBy {
            val start = it.duration - (it.duration % 10)
            val end = start + 9
            start..end
        }
        .maxBy { (_, group) -> group.size }
        ?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrincipleOptimal(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumByDouble(Trip::cost)
    val sortedDriversIncome: List<Double> = trips
        .groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble(Trip::cost) }
        .sortedDescending()

    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedDriversIncome
        .take(numberOfTopDrivers)
        .sum()

    return incomeByTopDrivers >= 0.8 * totalIncome
}

fun main(args: Array<String>) {
    taxiPark(
        1..5, 1..4,
        trip(1, 1, 20, 20.0),
        trip(1, 2, 20, 20.0),
        trip(1, 3, 20, 20.0),
        trip(1, 4, 20, 20.0),
        trip(2, 1, 20, 19.0)
    )
        .checkParetoPrinciple() eq true

    taxiPark(
        1..5, 1..4,
        trip(1, 1, 20, 20.0),
        trip(1, 2, 20, 20.0),
        trip(1, 3, 20, 20.0),
        trip(1, 4, 20, 20.0),
        trip(2, 1, 20, 21.0)
    )
        .checkParetoPrinciple() eq false
}

fun driver(i: Int) = Driver("D-$i")
fun passenger(i: Int) = Passenger("P-$i")
fun drivers(range: IntRange) = range.toList().map(::driver).toSet()

fun passengers(indices: List<Int>) = indices.map(::passenger).toSet()
fun passengers(range: IntRange) = passengers(range.toList())
fun passengers(vararg indices: Int) = passengers(indices.toList())

fun taxiPark(driverIndexes: IntRange, passengerIndexes: IntRange, vararg trips: Trip) =
    TaxiPark(drivers(driverIndexes), passengers(passengerIndexes), trips.toList())

fun trip(driverIndex: Int, passenger: Int, duration: Int = 10, distance: Double = 3.0, discount: Double? = null) =
    Trip(driver(driverIndex), passengers(passenger), duration, distance, discount)

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}