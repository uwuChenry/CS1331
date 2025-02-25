/**
 * Dinosaur class.
 * @author Po Cheng, Chen
 * @version 1.0
 */
public class Dinosaur {
    protected final String name;
    private double height;
    private double width;
    private double weight;
    protected static int totalEnclosures = 0;

    /**
     * Constructs a new Dinosaur with the specified name, height, width, and weight.
     *
     * @param name   the name of the dinosaur
     * @param height the height of the dinosaur
     * @param width  the width of the dinosaur
     * @param weight the weight of the dinosaur
     */
    public Dinosaur(String name, double height, double width, double weight) {
        if (name == null || name.equals("") || name.trim().equals("") || name.isBlank()) {
            this.name = "Barney";
        } else {
            this.name = name;
        }
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    /**
     * Constructs a new Dinosaur with default values.
     */
    public Dinosaur() {
        this("Barney", 15.0, 20.0, 1000.0);
    }

    /**
     * Constructs a new Dinosaur by copying the values from another Dinosaur.
     *
     * @param other the Dinosaur to copy
     */
    public Dinosaur(Dinosaur other) {
        this.name = other.name;
        this.height = other.height;
        this.width = other.width;
        this.weight = other.weight;
    }

    /**
     * Calculates the size of the enclosure required for the dinosaur.
     *
     * @return the size of the enclosure
     */
    public double enclosureSize() {
        return 10 * height * width;
    }

    /**
     * Calculates the amount of food required for the dinosaur.
     *
     * @return the amount of food required
     */
    public double calculateFood() {
        return weight * width * height;
    }

    /**
     * Returns a string representation of the dinosaur.
     *
     * @return a string representation of the dinosaur
     */
    @Override
    public String toString() {
        return String.format("%s requires a %.2f square foot enclosure and %.2f pounds of food.",
                name, enclosureSize(), calculateFood());
    }

    /**
     * Builds an enclosure for the dinosaur and returns a string indicating the result.
     *
     * @return a string indicating whether the dinosaur was added to the park or is too expensive
     */
    public String buildEnclosure() {
        if (enclosureSize() > 6000.0 || calculateFood() > 80000.0) {
            return this.toString() + " " + this.name + " is too expensive for the park!";
        }
        totalEnclosures++;
        return this.toString() + " " + this.name + " has been added to the park!";
    }

    /**
     * Returns the height of the dinosaur.
     *
     * @return the height of the dinosaur
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the width of the dinosaur.
     *
     * @return the width of the dinosaur
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the weight of the dinosaur.
     *
     * @return the weight of the dinosaur
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the name of the dinosaur.
     *
     * @return the name of the dinosaur
     */
    public String getName() {
        return name;
    }
}