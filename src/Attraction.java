public class Attraction implements Admittable {
    private final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    private final double admissionFee;
    private Group[] visitors = new Group[5];

    public Attraction (String name, double admissionFee) {
        if (name == null || name.trim().equals("")) {
            this.name = "No name";
        }
        else {
            this.name = name;
        }
        if (admissionFee < 0) {
            this.admissionFee = 0;
        }
        else {
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

    private void addVisitGroup(Group newGroup) {
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

    private Group[] visitorsToGroups(String[] names) {
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
        if (rating < 1) rating = 1;
        if (rating > 10) rating = 10;
        this.sumRatings += rating;
        this.numRatings++;
        this.visitors[index] = null;
        return 0;
    }
}
