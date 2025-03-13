/**
 * Represents a group of visitors.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Group {
    private final String[] people;

    /**
     * Constructs a Group with the specified array of people.
     *
     * @param people an array of people's names
     */
    public Group(String[] people) {
        if (people == null) {
            this.people = new String[0];
        } else {
            this.people = new String[people.length];
            for (int i = 0; i < people.length; i++) {
                this.people[i] = people[i];
            }
        }
    }

    /**
     * Returns the number of non-null people in the group.
     *
     * @return the size of the group
     */
    public int size() {
        int temp = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                temp++;
            }
        }
        return temp;
    }

    /**
     * Returns a string representation of the group.
     *
     * @return a string containing all people's names separated by "/"
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < people.length; i++) {
            result += people[i] + "/";
        }
        return result;
    }
}
