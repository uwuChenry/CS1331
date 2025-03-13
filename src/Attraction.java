public class Attraction implements Admittable, Comparable<Attraction> {
    protected final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    protected final double admissionFee;
    private Group[] visitors = new Group[5];

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

    public Attraction(String name) {
        this(name, 5.25);
    }

    @Override
    public void admit(String[] names) {
        Group[] groups = visitorsToGroups(names);
        for (Group group : groups) {
            addVisitGroup(group);
        }
    }

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

    public double averageRating() {
        if (this.numRatings == 0) {
            return 0;
        }
        return Math.round((double) this.sumRatings / (double) this.numRatings * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s/%.2f/%.2f", this.name, this.averageRating(), this.admissionFee);
    }

    public void printVisitors() {
        System.out.println(toString());
        for (int i = 0; i < this.visitors.length; i++) {
            Group group = this.visitors[i];
            if (group != null) {
                System.out.println("Group " + i + ": " + group.toString());
            }
        }
    }

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
}
