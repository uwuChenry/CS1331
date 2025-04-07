/**
 * This class represents a superhero.
 * A superhero has a name and is on an alliance, where the strength
 * of the alliance indicates the strength of the superhero.
 *
 * @author CS1331 TAs
 * @version 13.31
 */
public class Superhero implements Comparable<Superhero> {
    /**
     * The name of this superhero.
     */
    private final String name;

    /**
     * The alliance this superhero is on.
     */
    private final Alliance alliance;


    /**
     * Constructs a new Superhero instance with a name and alliance.
     *
     * @param name     the name of this superhero, must be non-null
     * @param alliance the alliance this superhero is on, must be non-null
     * @throws IllegalArgumentException if either name or alliance is null
     */
    public Superhero(String name, Alliance alliance) {
        if (name == null || alliance == null) {
            throw new IllegalArgumentException("name and alliance must be non-null!");
        }

        this.name = name;
        this.alliance = alliance;
    }

    /**
     * Constructs a new Superhero instance on alliance AVENGERS with the specified name.
     *
     * @param name the name of this superhero, must be non-null
     * @throws IllegalArgumentException if the name is null
     */
    public Superhero(String name) {
        this(name, Alliance.AVENGERS);
    }


    /**
     * Getter for alliance.
     *
     * @return the alliance this superhero is on
     */
    public Alliance getAlliance() {
        return alliance;
    }


    @Override
    public String toString() {
        return String.format("<%s, %s>", name, alliance.name());
    }

    /**
     * Compares this superhero with another superhero for order by comparing
     * the name of the two superheros lexicographically. This method returns
     * an integer equivalent to the return value of name.compareTo(other.name).
     * <p>
     * Note: Since this class does not override Object's implementation of equals,
     * this class has a natural ordering that is inconsistent with equals.
     *
     * @param other the other superhero to be compared
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object
     * @throws NullPointerException if the specified object is null
     */
    public int compareTo(Superhero other) {
        return name.compareTo(other.name);
    }
}