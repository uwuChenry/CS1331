public class Bus extends Vehicle{
    private String location;
    private int stopsPerMile;

    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }
    @Override
    public boolean canDrive(int distance) {
        return distance >= 0;
    }

    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1.0;
        }
        return distance * 3.0 / (double) stopsPerMile;
    }
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
        return true;
    }
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
    @Override
    public String toString() {
        String temp = 
        return String.format("%s is at %s and has travelled %d miles and has earned %.2f dollars.", this.id, this.location, this.numMiles, this.earnings);
    }
}
