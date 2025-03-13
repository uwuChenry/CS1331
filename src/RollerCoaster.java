/**
 * Represents a RollerCoaster attraction.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class RollerCoaster extends Attraction {
    private final int maxCapacity;
    private int occupancy = 0;

    /**
     * Constructs a RollerCoaster with the specified name, admission fee, and maximum capacity.
     *
     * @param name the name of the roller coaster
     * @param admissionFee the admission fee for the roller coaster
     * @param maxCapacity the maximum capacity of the roller coaster
     */
    public RollerCoaster(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        if (maxCapacity < 25) {
            this.maxCapacity = 25;
        } else {
            this.maxCapacity = maxCapacity;
        }
    }

    /**
     * Constructs a RollerCoaster with the specified name and default admission fee and capacity.
     *
     * @param name the name of the roller coaster
     */
    public RollerCoaster(String name) {
        this(name, 5.25, 25);
    }

    /**
     * Admits a group of people to the roller coaster.
     *
     * @param names the names of the people to admit
     */
    @Override
    public void admit(String[] names) {
        if (occupancy + names.length > maxCapacity) {
            System.out.println("RollerCoaster has reached maximum capacity. Please visit another time!");
            return;
        }
        super.admit(names);
        occupancy += names.length;
    }

    /**
     * Rates the roller coaster and exits a person from the ride.
     *
     * @param index the index of the person to rate and exit
     * @param rating the rating given by the person
     * @return the number of people exited, or -1 if the index is invalid
     */
    @Override
    public int rateAndExit(int index, int rating) {
        int temp = super.rateAndExit(index, rating);
        if (temp == -1) {
            return -1;
        }
        occupancy -= temp;
        return temp;
    }

    /**
     * Returns the percentage of occupancy of the roller coaster.
     *
     * @return the percentage of occupancy
     */
    public double percentOccupancy() {
        return Math.round(occupancy * 100.0 * 100.0 / maxCapacity) / 100.0;
    }

    /**
     * Returns a string representation of the roller coaster.
     *
     * @return a string representation of the roller coaster
     */
    @Override
    public String toString() {
        return String.format("RollerCoaster: %s/%.2f/%.2f/%.2f%%",
            this.getName(), this.averageRating(), this.getAdmissionFee(), this.percentOccupancy());
    }
}
