public class Group {
    private final String[] people;

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
    public int size() {
        int temp = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                temp++;
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < people.length; i++) {
            result += people[i] + "/";
        }
        return result;
    }
}
