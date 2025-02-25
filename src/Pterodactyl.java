/**
 * The Pterodactyl class represents a pterodactyl dinosaur with a specified flight ceiling.
 * It extends the Dinosaur class and adds the flight ceiling attribute.
 * @author Po Cheng, Chen
 * @version 1.0
 */
public class Pterodactyl extends Dinosaur {
    /**
     * The flight ceiling of the pterodactyl in feet.
     */
    private double flightCeiling;

    /**
     * Constructs a new Pterodactyl with the specified name, height, width, weight, and flight ceiling.
     *
     * @param name          the name of the pterodactyl
     * @param height        the height of the pterodactyl in feet
     * @param width         the width of the pterodactyl in feet
     * @param weight        the weight of the pterodactyl in pounds
     * @param flightCeiling the flight ceiling of the pterodactyl in feet
     */
    public Pterodactyl(String name, double height, double width, double weight, double flightCeiling) {
        super(name, height, width, weight);
        if (flightCeiling < 10 || flightCeiling > 100) {
            this.flightCeiling = 50.0;
        } else {
            this.flightCeiling = flightCeiling;
        }
    }

    /**
     * Constructs a new Pterodactyl with the specified name and width.
     * The height is set to 15.0 feet, the weight is set to 1000.0 pounds, and the flight ceiling is set to 50.0 feet.
     *
     * @param name  the name of the pterodactyl
     * @param width the width of the pterodactyl in feet
     */
    public Pterodactyl(String name, double width) {
        this(name, 15.0, width, 1000.0, 50.0);
    }

    /**
     * Constructs a new Pterodactyl with the specified name.
     * default height = 15.0, width = 20.0, weight = 1000.0, flightCeiling = 50.0
     *
     * @param name the name of the pterodactyl
     */
    public Pterodactyl(String name) {
        this(name, 12.0);
    }

    /**
     * Constructs a new Pterodactyl by copying the values from another Pterodactyl.
     *
     * @param other the Pterodactyl to copy
     */
    public Pterodactyl(Pterodactyl other) {
        super(other.getName(), other.getHeight(), other.getWidth(), other.getWeight());
        this.flightCeiling = other.flightCeiling;
    }

    /**
     * Calculates the size of the enclosure required for the pterodactyl.
     *
     * @return the size of the enclosure in square feet
     */
    @Override
    public double enclosureSize() {
        return 4 * this.getHeight() * this.getWidth() + flightCeiling;
    }

    /**
     * Returns a string representation of the pterodactyl.
     *
     * @return a string representation of the pterodactyl
     */
    @Override
    public String toString() {
        return String.format(
            "%s can fly %.2f feet into the air! %s requires a %.2f square foot enclosure and %.2f pounds of food.",
            this.getName(), flightCeiling, this.getName(), enclosureSize(), calculateFood());
    }
}