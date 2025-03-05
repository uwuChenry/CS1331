/**
 * The Vehicle class represents a generic vehicle with an ID, earnings, miles traveled, and passengers.
 * @author Po Cheng Chen
 * @version 1.0
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    /**
     * Constructs a Vehicle with the specified ID, number of miles, and passengers.
     *
     * @param id the ID of the vehicle
     * @param numMiles the number of miles the vehicle has traveled
     * @param passengers the passengers in the vehicle
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        this.earnings = 0;
    }

    /**
     * Constructs a Vehicle with the specified ID and passengers.
     *
     * @param id the ID of the vehicle
     * @param passengers the passengers in the vehicle
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Determines if the vehicle can drive the specified distance.
     *
     * @param distance the distance to drive
     * @return true if the vehicle can drive the distance, false otherwise
     */
    public abstract boolean canDrive(int distance);

    /**
     * Calculates the cost of driving the specified distance.
     *
     * @param distance the distance to drive
     * @return the cost of driving the distance
     */
    public abstract double calculateCost(int distance);

    /**
     * Adds passengers to the vehicle for the specified distance.
     *
     * @param distance the distance to drive
     * @param passenger the passengers to add
     * @return true if the passengers were added successfully, false otherwise
     */
    public abstract boolean addPassengers(int distance, String[] passenger);

    /**
     * Charges the ride for the specified distance.
     *
     * @param distance the distance to drive
     */
    public void chargeRide(int distance) {
        if (!canDrive(distance)) {
            return;
        }
        this.earnings += calculateCost(distance);
        this.numMiles += distance;
    }

    /**
     * Charges the ride for the specified distance and number of passengers.
     *
     * @param distance the distance to drive
     * @param numPassenger the number of passengers
     */
    public void chargeRide(int distance, int numPassenger) {
        if (!canDrive(distance)) {
            return;
        }
        this.earnings += calculateCost(distance) * numPassenger;
        this.numMiles += distance;
    }

    /**
     * Checks if this vehicle is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the vehicles are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return this.id.equals(other.id) && this.numMiles == other.numMiles;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + Integer.hashCode(this.numMiles);
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return String.format(
            "%s has travelled %d miles and has earned %.2f dollars.",
            this.id, this.numMiles, this.earnings);
    }
}
