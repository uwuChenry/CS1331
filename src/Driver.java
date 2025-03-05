/**
 * The Driver class contains the main method to test the Car and Bus classes.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Driver {
    /**
     * The main method to test the Car and Bus classes.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Car car1 = new Car("car1", 0, 100);
        Car car2 = new Car("car1", 0, 100);
        System.out.println(car1.addPassengers(50, new String[]{"Alice", "Bob"}));
        System.out.println(car2.addPassengers(50, new String[]{"Alice", "Bob"}));
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car1.equals(car2));

        Bus bus1 = new Bus("bus1", 0, "Seattle", 2);
        Bus bus2 = new Bus("bus1", 0, "Seattle", 2);
        bus1.addPassengers(50, new String[]{"Alice", "Bob"});
        bus2.addPassengers(50, new String[]{"Alice", "Bob"});
        System.out.println(bus1.toString());
        System.out.println(bus2.toString());
        System.out.println(bus1.equals(bus2));
    }
}
