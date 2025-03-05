public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        this.earnings = 0;
    }
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    public abstract boolean canDrive(int distance);
    public abstract double calculateCost(int distance);
    public abstract boolean addPassenger(int distance, String[] passenger);
    public void chargeRide(int distance) {
        if (!canDrive(distance)) {
            return;
        }
        this.earnings += calculateCost(distance);
        this.numMiles += distance;
    }
    public void chargeRide(int distance, int numPassenger) {
        if (!canDrive(distance)) {
            return;
        }
        this.earnings += calculateCost(distance) * numPassenger;
        this.numMiles += distance;
    }
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
    public String toString() {
        return String.format("%s has travelled %d miles and has earned %.2f dollars.", this.id, this.numMiles, this.earnings);
    }

}
