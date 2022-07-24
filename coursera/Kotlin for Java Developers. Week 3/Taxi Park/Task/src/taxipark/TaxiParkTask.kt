package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter { driver -> this.trips.none { it.driver == driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers.filter { passenger -> trips.count { it.passengers.contains(passenger) } >= minTrips }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.allPassengers.filter { passenger -> this.trips.count { it.driver == driver && it.passengers.contains(passenger) } > 1 }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    this.allPassengers.filter { passenger ->
        this.trips.filter { it.passengers.contains(passenger) }.partition { (it.discount ?: 0.0) > 0.0 }
            .run { first.size > second.size }
    }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return this.trips.groupBy { it.duration - (it.duration % 10) }.maxBy { (_, value) -> value.size }?.run { key..(key + 9) }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val driverStats = this.trips.groupBy { it.driver }.mapValues { (_, value) -> value.sumByDouble { it.cost } }
        .toList().sortedBy { -it.second }
    val eightyPercentCost = driverStats.sumByDouble { it.second } * 0.8
    val twentyPercentDriver = this.allDrivers.size * 0.2
    var costRunningTotal = 0.0
    driverStats.forEachIndexed { index, pair ->
        if (index + 1 <= twentyPercentDriver) {
            costRunningTotal += pair.second
            if (costRunningTotal >= eightyPercentCost) {
                return true
            }
        } else {
            return false
        }
    }
    return false
}