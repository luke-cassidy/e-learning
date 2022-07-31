package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers - this.trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= minTrips }
        .keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    this.allPassengers
        .associate { passenger ->
            passenger to this.trips.filter { passenger in it.passengers }
        }.filterValues { group ->
            val (withDiscount, withoutDiscount) = group.partition { it.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
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