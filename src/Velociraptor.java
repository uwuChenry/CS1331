public class Velociraptor extends Dinosaur {
    int speed;
    Pack pack;
    public Velociraptor(String name, double height, double width, double weight, int speed, Pack pack) {
        super(name, height, width, weight);
        if (speed < 0) {
            this.speed = 30;
        } else {
            this.speed = speed;
        }
        //might be null
        this.pack = pack;
    }

    public Velociraptor(String name, double height) {
        this("Velociraptor", height, 20.0, 1000.0, 30, null);
    }

    public Velociraptor(Velociraptor other) {
        super(other.name, other.height, other.width, other.weight);
        this.speed = other.speed;
        this.pack = other.pack;
    }

    @Override
    public double enClosureSize() {
        if (pack == null) {
            return 4 * height * width;
        }
        return pack.getSize() * height * width;
    }

    @Override
    public double calculateFood() {
        return weight * speed * height;
    }

    @Override
    public String toString() {
        if (pack == null) {
            return String.format(
                "$s requires a %f square foot enclosure and %f pounds of food.", 
                this.name, enClosureSize(), calculateFood());
        }
        return String.format(
            "%s is a family of dinosaurs of size %d! %s requires a %f square foot enclosure and %f pounds of food.",
            pack.getName(), pack.getSize(), this.name, enClosureSize(), calculateFood()
        );
    }
}
