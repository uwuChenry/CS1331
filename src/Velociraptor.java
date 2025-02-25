/**
 * The Velociraptor class represents a velociraptor dinosaur with a specified speed and pack.
 * It extends the Dinosaur class and adds the speed and pack attributes.
 * @author Po Cheng, Chen
 * @version 1.0
 */
public class Velociraptor extends Dinosaur {
    private int speed;
    private Pack pack;

    /**
     * Constructs a new Velociraptor with the specified name, height, width, weight, speed, and pack.
     *
     * @param name   the name of the velociraptor
     * @param height the height of the velociraptor
     * @param width  the width of the velociraptor
     * @param weight the weight of the velociraptor
     * @param speed  the speed of the velociraptor
     * @param pack   the pack to which the velociraptor belongs
     */
    public Velociraptor(String name, double height, double width, double weight, int speed, Pack pack) {
        super(name, height, width, weight);
        if (speed < 0) {
            this.speed = 30;
        } else {
            this.speed = speed;
        }
        // might be null
        this.pack = pack;
    }

    /**
     * Constructs a new Velociraptor with the specified name and height.
     * Default values are width = 20.0, weight = 1000.0, speed = 30, pack = null.
     *
     * @param name   the name of the velociraptor
     * @param height the height of the velociraptor in feet
     */
    public Velociraptor(String name, double height) {
        this(name, height, 20.0, 1000.0, 30, null);
    }

    /**
     * Constructs a new Velociraptor by copying the values from another Velociraptor.
     *
     * @param other the Velociraptor to copy
     */
    public Velociraptor(Velociraptor other) {
        super(other.getName(), other.getHeight(), other.getWidth(), other.getWeight());
        this.speed = other.speed;
        this.pack = other.pack;
    }

    /**
     * Calculates the size of the enclosure required for the velociraptor.
     *
     * @return the size of the enclosure
     */
    @Override
    public double enclosureSize() {
        if (pack == null) {
            return 4 * this.getHeight() * this.getWidth();
        }
        return pack.getSize() * this.getHeight() * this.getWidth();
    }

    /**
     * Calculates the amount of food required for the velociraptor.
     *
     * @return the amount of food required
     */
    @Override
    public double calculateFood() {
        return this.getWeight() * speed * this.getHeight();
    }

    /**
     * Returns a string representation of the velociraptor.
     *
     * @return a string representation of the velociraptor
     */
    @Override
    public String toString() {
        if (pack == null) {
            return String.format(
                "%s requires a %.2f square foot enclosure and %.2f pounds of food.",
                this.getName(), enclosureSize(), calculateFood());
        }
        return String.format(
            "%s is a family of dinosaurs of size %d! %s requires a %.2f square foot enclosure and %.2f pounds of food.",
            pack.getName(), pack.getSize(), this.getName(), enclosureSize(), calculateFood()
        );
    }
}