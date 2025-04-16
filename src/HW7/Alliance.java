package HW7;
/**
 * This enum represents the possible alliances a superhero can be
 * on: AVENGERS, XMEN, and FANTASICFOUR. In addition, each alliance has a
 * strength associated with it (the strength is completely arbitrary).
 *
 * @author CS1331 TAs
 * @version 13.31
 */
public enum Alliance {
    /**
     * The singleton instance for the Avengers alliance.
     * Superheroes on this alliance have a strength of 2.5.
     */
    AVENGERS(2.5),

    /**
     * The singleton instance for the Xmen.
     * Superheroes on this alliance have a strength of 3.0.
     */
    XMEN(3.0),

    /**
     * The singleton instance for the Fantastic Four.
     * Superheroes on this alliance have a strength of 3.5.
     */
    FANTASTIC_FOUR(3.5);


    /**
     * The strength of the superheroes on this alliance.
     */
    private final double strength;


    Alliance(double strength) {
        this.strength = strength;
    }


    /**
     * Getter for strength.
     *
     * @return the strength of this alliance
     */
    public double getStrength() {
        return strength;
    }
}