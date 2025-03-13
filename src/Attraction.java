/**
 * Attraction implements Admittable and Comparable.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Attraction implements Admittable, Comparable<Attraction> {
    private final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    private final double admissionFee;
    private Group[] visitors = new Group[5];

    /**
     * Constructs an Attraction with the specified name and admission fee.
     *
     * @param name the name of the attraction
     * @param admissionFee the admission fee for the attraction
     */
    public Attraction(String name, double admissionFee) {
        if (name == null || name.trim().equals("")) {
            this.name = "No name";
        } else {
            this.name = name;
        }
        if (admissionFee < 0) {
            this.admissionFee = 0;
        } else {
            this.admissionFee = admissionFee;
        }
    }

    /**
     * Constructs an Attraction with the specified name and a default admission fee of 5.25.
     *
     * @param name the name of the attraction
     */
    public Attraction(String name) {
        this(name, 5.25);
    }

    /**
     * Admits a group of visitors to the attraction.
     *
     * @param names the names of the visitors
     */
    @Override
    public void admit(String[] names) {
        Group[] groups = visitorsToGroups(names);
        for (Group group : groups) {
            addVisitGroup(group);
        }
    }

    /**
     * Adds a group of visitors to the attraction.
     *
     * @param newGroup the group of visitors to add
     */
    protected void addVisitGroup(Group newGroup) {
        boolean success = false;
        for (int i = 0; i < this.visitors.length; i++) {
            if (this.visitors[i] == null) {
                this.visitors[i] = newGroup;
                success = true;
                break;
            }
        }
        if (!success) {
            Group[] newGroups = new Group[this.visitors.length * 2];
            for (int i = 0; i < this.visitors.length; i++) {
                newGroups[i] = this.visitors[i];
            }
            newGroups[this.visitors.length] = newGroup;
            this.visitors = newGroups;
        }
    }

    /**
     * Converts an array of visitor names into groups of up to 5 visitors each.
     *
     * @param names visitors
     * @return array of groups
     */
    protected Group[] visitorsToGroups(String[] names) {
        int numGroup = (int) Math.ceil(names.length / 5.0);
        Group[] groups = new Group[numGroup];
        for (int i = 0; i < numGroup; i++) {
            String[] people = new String[Math.min(5, names.length - 5 * i)];
            for (int j = 0; j < people.length; j++) {
                people[j] = names[5 * i + j];
            }
            groups[i] = new Group(people);
        }
        return groups;
    }

    /**
     * Rates the attraction and removes a group of visitors at the specified index.
     *
     * @param index the index of the group to remove
     * @param rating the rating given by the group
     * @return the size of the group that was removed
     */
    public int rateAndExit(int index, int rating) {
        if (index < 0 || index >= this.visitors.length || this.visitors[index] == null) {
            System.out.println("Could not update rating. Index invalid.");
            return -1;
        }
        if (rating < 1) {
            rating = 1;
        }
        if (rating > 10) {
            rating = 10;
        }
        int temp = this.visitors[index].size();
        this.sumRatings += rating;
        this.numRatings++;
        this.visitors[index] = null;
        for (int i = index; i < this.visitors.length - 1; i++) {
            this.visitors[i] = this.visitors[i + 1];
        }
        this.visitors[this.visitors.length - 1] = null;
        return temp;
    }

    /**
     * Calculates the average rating of the attraction.
     *
     * @return the average rating of the attraction
     */
    public double averageRating() {
        if (this.numRatings == 0) {
            return 0;
        }
        return Math.round((double) this.sumRatings / (double) this.numRatings * 100.0) / 100.0;
    }

    /**
     * Returns a string representation of the attraction.
     *
     * @return a string representation of the attraction
     */
    @Override
    public String toString() {
        return String.format("%s/%.2f/%.2f", this.name, this.averageRating(), this.admissionFee);
    }

    /**
     * Prints visitors.
     */
    public void printVisitors() {
        System.out.println(toString());
        for (int i = 0; i < this.visitors.length; i++) {
            Group group = this.visitors[i];
            if (group != null) {
                System.out.println("Group " + i + ": " + group.toString());
            }
        }
    }

    /**
     * Compares this attraction to another attraction based on average rating and admission fee.
     *
     * @param other the other attraction to compare to
     * @return a negative integer, zero, or a positive integer
     */
    @Override
    public int compareTo(Attraction other) {
        if (other == null) {
            return -1;
        }
        if (this.averageRating() < other.averageRating()) {
            return -1;
        }
        if (this.averageRating() > other.averageRating()) {
            return 1;
        }
        if (this.averageRating() == other.averageRating()) {
            if (this.admissionFee > other.admissionFee) {
                return 1;
            }
            if (this.admissionFee < other.admissionFee) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Returns the admission fee of the attraction.
     *
     * @return the admission fee of the attraction
     */
    public double getAdmissionFee() {
        return admissionFee;
    }

    /**
     * Returns the name of the attraction.
     *
     * @return the name of the attraction
     */
    public String getName() {
        return name;
    }
}
