package HW2;
public class HWDriver {
    public static void main(String[] args) {
        
        //Intended default values
        double HEIGHT = 15.0;
        double WEIGHT = 1000.0;
        double WIDTH = 20.0;
        String NAME = "Barney";
        String PKNAME = "The Power Pack";
        String PRINT = "%s requires a %.2f square foot enclosure and %.2f pounds of food.";
        String PPRINT = "%1$s can fly %2$.2f feet into the air! %1$s requires a %3$.2f square foot enclosure and %4$.2f pounds of food.";
        String PKPRINT = "%s is a family of dinosaurs of size %d!";
        double FLIGHTCEILING = 50.0;
        double PWIDTH = 12.0;
        int SPEED = 30;

        //My test values
        String name = "ladev";
        double height = 18.426;
        double width = 3.491;
        double weight = 613.4513;
        double flightCeiling = 72.3165;
        double pWidth = 15.9919;
        int speed = 54;

        
        System.out.println("Dinosaur CLASS TEST");

        //Dinosaur constructor
        Dinosaur fullDino = new Dinosaur(name, height, width, weight);
        Dinosaur emptyDino = new Dinosaur();
        String largePrint = String.format(PRINT, name, 10 * width * height, height * width * weight);
        // System.out.println(largePrint);
        // System.out.println(fullDino.toString());
        String emptyPrint = String.format(PRINT, NAME, 10 * WIDTH * HEIGHT, HEIGHT * WIDTH * WEIGHT);
        System.out.println("toString for large constructor: " + largePrint.equals(fullDino.toString()));
        System.out.println("toString for empty constructor: " + emptyPrint.equals(emptyDino.toString()));
        Dinosaur copyDino = new Dinosaur(fullDino);
        System.out.println("toString for copy constructor: " + largePrint.equals(copyDino.toString()));

        //Name edge cases
        Dinosaur name1 = new Dinosaur(null, height, width, weight);
        Dinosaur name2 = new Dinosaur("", height, width, weight);
        Dinosaur name3 = new Dinosaur("     ", height, width, weight);
        String nameTest = String.format(PRINT, "Barney", 10 * width * height, height * width * weight);
        System.out.println("nullname behavior: " + nameTest.equals(name1.toString()));
        System.out.println("emptyname behavior: " + nameTest.equals(name2.toString()));
        System.out.println("blankname behavior: " + nameTest.equals(name3.toString()));

        //building for dinos
        System.out.println("build success: " + fullDino.buildEnclosure().equals(largePrint + " " + name + " has been added to the park!"));
        // System.out.println(emptyDino.buildEnclosure());
        // System.out.println(emptyPrint + " Barney is too expensive for the park!");
        System.out.println("build failure (food): " + emptyDino.buildEnclosure().equals(emptyPrint + " Barney is too expensive for the park!"));
        copyDino = new Dinosaur("tall", 7000, 1, 1);
        String tallPrint = String.format(PRINT, "tall", 70000.0, 7000.0);
        System.out.println("build failure (size): " + copyDino.buildEnclosure().equals(tallPrint + " tall is too expensive for the park!"));
        
        //Pterodactyl test
        System.out.println("Pterodactyl CLASS TEST");
        Pterodactyl fullPtero = new Pterodactyl(name, height, width, weight, flightCeiling);
        Pterodactyl mediumPtero = new Pterodactyl("Amelia", pWidth);
        Pterodactyl smallPtero = new Pterodactyl("wings");
        Pterodactyl copyPtero = new Pterodactyl(fullPtero);

        largePrint = String.format(PPRINT, name, flightCeiling, 4 * width * height + flightCeiling, height * width * weight);
        System.out.println("toString for full constructor: " + largePrint.equals(fullPtero.toString()));
        System.out.println("toString for copy constructor: " + largePrint.equals(copyPtero.toString()));
        largePrint = String.format(PPRINT, "Amelia", FLIGHTCEILING, 4 * pWidth * HEIGHT + FLIGHTCEILING, HEIGHT * pWidth * WEIGHT);
        System.out.println("toString for 2-arg constructor: " + largePrint.equals(mediumPtero.toString()));
        largePrint = String.format(PPRINT, "wings", FLIGHTCEILING, 4 * PWIDTH * HEIGHT + FLIGHTCEILING, HEIGHT * PWIDTH * WEIGHT);
        System.out.println("toString for 1-arg constructor: " + largePrint.equals(smallPtero.toString()));

        //pack test why are you actually reading my driver file trust me it works
        System.out.println("Pack CLASS TEST");
        Pack packTest = new Pack(0, "nopack");
        String pkprint = String.format(PKPRINT, "nopack", 0);
        System.out.println("toString for valid pack consruction: " + pkprint.equals(packTest.toString()));
        packTest = new Pack(-1, "Kazzoque");
        pkprint = String.format(PKPRINT, "Kazzoque", 4);
        System.out.println("toString for invalid pack number: " + pkprint.equals(packTest.toString()));
        Pack pname1 = new Pack(2, null);
        Pack pname2 = new Pack(2, "");
        Pack pname3 = new Pack(2, "   ");
        pkprint = String.format(PKPRINT, PKNAME, 2);
        System.out.println("nullname behavior: " + pkprint.equals(pname1.toString()));
        System.out.println("emptyname behavior: " + pkprint.equals(pname2.toString()));
        System.out.println("blankname behavior: " + pkprint.equals(pname3.toString()));

        //velociraptor testing
        System.out.println("Velociraptor CLASS TEST");
        packTest = new Pack(3, "Kazzoque");
        Velociraptor fullVelo = new Velociraptor(name, height, width, weight, speed, packTest);
        Velociraptor smallVelo = new Velociraptor(name , height);
        Velociraptor copyVelo = new Velociraptor(fullVelo);
        largePrint = String.format(PKPRINT + " " + PRINT, "Kazzoque", 3, name, width * height * 3, weight * speed * height);
        System.out.println("toString for full constructor: " + largePrint.equals(fullVelo.toString()));
        System.out.println("toString for copy constructor: " + largePrint.equals(copyVelo.toString()));
        largePrint = String.format(PRINT, name, WIDTH * height * 4, WEIGHT * SPEED * height);
        System.out.println("toString for 2-arg constructor: " + largePrint.equals(smallVelo.toString()));
        // System.out.println(largePrint);
        // System.out.println(smallVelo.toString());
        fullVelo = new Velociraptor(name, height, WIDTH, WEIGHT, -1, null);
        System.out.println("toString for invalid speed: " + largePrint.equals(fullVelo.toString()));
    }
}