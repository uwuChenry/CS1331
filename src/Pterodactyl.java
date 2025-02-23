public class Pterodactyl extends Dinosaur {
    protected double flightCeiling;
    public Pterodactyl(String name, double height, double width, double weight, double flightCeiling) {
        super(name, height, width, weight);
        if (flightCeiling < 10 || flightCeiling > 100) {
            this.flightCeiling = 50.0;
        } else {
            this.flightCeiling = flightCeiling;
        }
    }

    public Pterodactyl(String name, double width) {
        this("Pterodactyl", 15.0, width, 1000.0, 50.0);
    }

    public Pterodactyl(String name) {
        this(name, 12.0);
    }

    public Pterodactyl(Pterodactyl other) {
        super(other.name, other.height, other.width, other.weight);
        this.flightCeiling = other.flightCeiling;
    }

    @Override
    public double enClosureSize() {
        return 4 * height * width + flightCeiling;
    }

    @Override
    public String toString() {
        return String.format(
            "%s can fly %f feet into the air! %s requires a %f square foot enclosure and %f pounds of food.",
            name, flightCeiling, name, enClosureSize(), calculateFood());
    }    
}
