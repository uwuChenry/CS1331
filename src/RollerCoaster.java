public class RollerCoaster extends Attraction {
    private final int maxCapacity;
    private int occupancy = 0;

    public RollerCoaster(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        if (maxCapacity < 25) {
            this.maxCapacity = 25;
        } else {
            this.maxCapacity = maxCapacity;
        }
    }

    public RollerCoaster(String name) {
        this(name, 5.25, 25);
    }

    @Override
    public void admit(String[] names) {
        if (occupancy + names.length > maxCapacity) {
            System.out.println("RollerCoaster has reached maximum capacity. Please visit another time!");
            return;
        }
        super.admit(names);
        occupancy += names.length;
    }

    @Override
    public int rateAndExit(int index, int rating) {
        int temp = super.rateAndExit(index, rating);
        if (temp == -1) {
            return -1;
        }
        occupancy -= temp;
        return temp;
    }

    public double percentOccupancy() {
        return Math.round(occupancy * 100.0 * 100.0 / maxCapacity) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Rollercoaster: %s/%.2f/%.2f/%.2f",
            this.name, this.averageRating(), this.admissionFee, this.percentOccupancy());
    }
}
