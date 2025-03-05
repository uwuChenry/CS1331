/**
 * The Bus class represents a bus that extends the Vehicle class.
 * It includes additional properties such as location and stopsPerMile.
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * Constructs a Bus object with the specified parameters.
     *
     * @param id the ID of the bus
     * @param numMiles the number of miles the bus has driven
     * @param location the location where the bus operates
     * @param stopsPerMile the number of stops per mile
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * Constructs a Bus object with the specified ID and location.
     *
     * @param id the ID of the bus
     * @param location the location where the bus operates
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    /**
     * Checks if the bus can drive the specified distance.
     *
     * @param distance the distance to check
     * @return true if the bus can drive the distance, false otherwise
     */
    @Override
    public boolean canDrive(int distance) {
        return distance >= 0;
    }

    /**
     * Calculates the cost to drive the specified distance.
     *
     * @param distance the distance to drive
     * @return the cost to drive the distance, or -1.0 if the bus cannot drive the distance
     */
    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1.0;
        }
        return distance * 3.0 / (double) stopsPerMile;
    }

    /**
     * Adds passengers to the bus if it can drive the specified distance.
     *
     * @param distance the distance to drive
     * @param passengers the new passengers to add
     * @return true if the passengers were added, false otherwise
     */
    @Override
    public boolean addPassenger(int distance, String[] passengers) {
        if (!canDrive(distance)) {
            return false;
        }
        for (int i = 0; i < passengers.length; i++) {
            for (int j = 0; j < this.passengers.length; j++) {
                if (this.passengers[j] == null) {
                    this.passengers[j] = passengers[i];
                    break;
                }
            }
        }
        int currPassengers = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                currPassengers += 1;
            }
        }
        chargeRide(distance, currPassengers);
        return true;
    }

    /**
     * Checks if this bus is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) obj;
        return super.equals(obj) && this.location.equals(other.location) && this.stopsPerMile == other.stopsPerMile;
    }

    /**
     * Returns a hash code value for the bus.
     *
     * @return a hash code value for this bus
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + stopsPerMile;
        return result;
    }

    /**
     * Returns a string representation of the bus.
     *
     * @return a string representation of the bus
     */
    @Override
    public String toString() {
        String temp = "Bus " + super.toString();
        return temp + String.format(" This bus drives around %s and makes %d stops per mile.", location, stopsPerMile);
    }
}
