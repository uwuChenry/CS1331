/**
 * The Car class represents a car that extends the Vehicle class.
 * It includes additional properties such as rate, fees, and maxNumMiles.
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * Constructs a Car object with the specified parameters.
     *
     * @param id the ID of the car
     * @param numMiles the number of miles the car has driven
     * @param passengers the passengers in the car
     * @param rate the rate per mile
     * @param fees the one-time fee
     * @param maxNumMiles the maximum number of miles the car can drive
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * Constructs a Car object with the specified parameters.
     *
     * @param id the ID of the car
     * @param numMiles the number of miles the car has driven
     * @param maxNumMiles the maximum number of miles the car can drive
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10.0, 15.0, maxNumMiles);
    }

    /**
     * Constructs a Car object with the specified ID.
     *
     * @param id the ID of the car
     */
    public Car(String id) {
        this(id, 0, new String[4], 10.0, 15.0, 200);
    }

    /**
     * Checks if the car can drive the specified distance.
     *
     * @param distance the distance to check
     * @return true if the car can drive the distance, false otherwise
     */
    @Override
    public boolean canDrive(int distance) {
        if (distance < 0) {
            return false;
        }
        return this.numMiles + distance <= this.maxNumMiles;
    }

    /**
     * Calculates the cost to drive the specified distance.
     *
     * @param distance the distance to drive
     * @return the cost to drive the distance, or -1.0 if the car cannot drive the distance
     */
    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1.0;
        }
        return this.rate * distance + this.fees;
    }

    /**
     * Adds passengers to the car if it can drive the specified distance.
     *
     * @param distance the distance to drive
     * @param newPassengers the new passengers to add
     * @return true if the passengers were added, false otherwise
     */
    @Override
    public boolean addPassenger(int distance, String[] newPassengers) {
        if (!canDrive(distance)) {
            return false;
        }
        int count = newPassengers.length;
        for (int i = 0; i < newPassengers.length; i++) {
            for (int j = 0; j < this.passengers.length; j++) {
                if (this.passengers[j] == null) {
                    this.passengers[j] = newPassengers[i];
                    count--;
                    break;
                }
            }
        }
        if (count > 0) {
            return false;
        }
        chargeRide(distance);
        return true;
    }

    /**
     * Checks if this car is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car other = (Car) obj;
        return super.equals(obj) && this.rate == other.rate && this.fees == other.fees && this.maxNumMiles == other.maxNumMiles;
    }

    /**
     * Returns a string representation of the car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        String temp = "Car " + super.toString();
        return temp + String.format(" It can only drive %d miles. It costs %.2f dollars per mile and there is a one-time fee of %.2f dollars.", this.maxNumMiles, this.rate, this.fees);
    }
}
