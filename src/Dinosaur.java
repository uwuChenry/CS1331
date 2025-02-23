public class Dinosaur {
    protected final String name;
    protected double height;
    protected double width;
    protected double weight;
    protected static int totalEnclosures =0;

    public Dinosaur(String name, double height, double width, double weight) {
        if (name == null || name.equals("")) {
            this.name = "Barney";
        } else {
            this.name = name;
        }
        this.height = height;
        this.width = width;
        this.weight = weight;
    }
    public Dinosaur(){
        this("Barney", 15.0, 20.0, 1000.0);
    }
    public Dinosaur(Dinosaur other) {
        this.name = other.name;
        this.height = other.height;
        this.width = other.width;
        this.weight = other.weight;
    }

    public double enClosureSize() {
        return 10 * height * width;
    }

    public double calculateFood() {
        return weight * width * height;
    }

    public String toString() {
        return String.format("%s requires a %f square foot enclosure and %f pounds of food.", name, enClosureSize(), calculateFood());
    }

    public String buildEnclosure() {
        if (enClosureSize() > 6000.0 || calculateFood() > 80000.0) {
            return " " + this.name + " is too expensive for the park!";
        }
        totalEnclosures++;
        return " " + this.name + " has been added to the park!";
    }

    
}
