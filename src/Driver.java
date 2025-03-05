public class Driver {
    public static void main(String[] args) {
        Car car1 = new Car("car1", 0, 100);
        Car car2 = new Car("car1", 0, 100);
        car1.addPassenger(50, new String[]{"Alice", "Bob"});
        car2.addPassenger(99, new String[]{"Alice", "Bob"});
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car1.equals(car2));

        Bus bus1 = new Bus("bus1", 0, "Seattle", 2);
        Bus bus2 = new Bus("bus1", 0, "Seattle", 2);
        bus1.addPassenger(50, new String[]{"Alice", "Bob"});
        bus2.addPassenger(50, new String[]{"Alice", "Bob"});
        System.out.println(bus1.toString());
        System.out.println(bus2.toString());
        System.out.println(bus1.equals(bus2));
    }
}
