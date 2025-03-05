public class Car extends Vehicle{
    private double rate;
    private double fees;
    private int maxNumMiles;

    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10.0, 15.0, maxNumMiles);
    }
    public Car(String id) {
        this(id, 0, new String[4], 10.0, 15.0, 200);
    }

    @Override
    public boolean canDrive(int distance) {
        if (distance < 0) {
            return false;
        }
        return this.numMiles + distance <= this.maxNumMiles;
    }
    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1.0;
        }
        return this.rate * distance + this.fees;
    }
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
        return true;
    }
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
    @Override
    public String toString() {
        String temp = "Car " + super.toString();
        return temp + String.format(" It can only drive %d miles. It costs %.2f dollars per mile and there is a one-time fee of %.2f dollars.", this.maxNumMiles, this.rate, this.fees);
    }
}
