package HW4;
/**
 * Driver class.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class TripGuide {
    /**
     * The main method for testing.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Attraction[] attractions = {
            new Attraction("Thetraction", 40.0),
            new Attraction("Magnet", 40.0),
            new RollerCoaster("Raleigh", 40.0, 2),
            new Attraction(""),
            new RollerCoaster("", 6.20, 33),
            new RollerCoaster("Jjjjjjjjjjj", 7.10, 25)
        };

        String[] people4 = {"Ealice", "Gob", "Halice", "Jalice"};
        String[] people5 = {"Qob", "Ralice", "Sob", "Talice", "Uob"};
        String[] people12 = {
            "Valice", "Xob", "Yalice", "Zob", "Balice", "Cobb",
            "Dalice", "Eob", "Falice", "Grub", "Halice", "Iob"
        };
        String[] people25 = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
            "twenty-four", "twenty-five"
        };

        // admit the same people to all attractions
        // print out results of admit, for some of the attractions
        attractions[0].admit(people25);
        attractions[0].printVisitors();
        attractions[0].admit(people5);
        attractions[0].printVisitors();
        attractions[0].admit(people4);
        attractions[0].printVisitors();
        attractions[0].admit(people12); // should expand array
        attractions[0].printVisitors();
        System.out.println();

        System.out.println("Quietly adding to Magnet...");
        attractions[1].admit(people12);
        attractions[1].admit(people5);
        attractions[1].admit(people4);
        attractions[1].admit(people12);

        // also see results for a RollerCoaster
        attractions[2].admit(people12);
        attractions[2].printVisitors();
        attractions[2].admit(people5);
        attractions[2].printVisitors();
        attractions[2].admit(people4);
        attractions[2].printVisitors();
        attractions[2].admit(people12); // over capacity
        attractions[2].printVisitors();
        System.out.println();

        System.out.println("Quietly adding to No Name...");
        attractions[3].admit(people12);
        attractions[3].admit(people5);
        attractions[3].admit(people4);
        attractions[3].admit(people12);

        System.out.println("Quietly adding to RollerCoaster No Name...");
        attractions[4].admit(people12);
        attractions[4].admit(people5);
        attractions[4].admit(people4);
        attractions[4].admit(people12);

        System.out.println("Quietly adding to RollerCoaster Jjjjjjjjjjj...");
        attractions[5].admit(people12);
        attractions[5].admit(people5);
        attractions[5].admit(people4);
        attractions[5].admit(people12); // over capacity



        // exit the same groups from an Attraction and a RollerCoaster
        System.out.println("\nExiting the same groups (Thetraction, RollerCoaster Raleigh) ...");
        attractions[0].rateAndExit(0, 4);
        attractions[0].rateAndExit(2, 2);
        // attractions[0].printVisitors();
        attractions[2].rateAndExit(0, 4);
        attractions[2].rateAndExit(2, 2);
        // attractions[2].printVisitors();

        System.out.println("\n\n\n");
        System.out.println("\n\n\n\n");
        attractions[1].printVisitors();
        attractions[4].printVisitors();
        // exit different groups from an Attraction and a RollerCoaster
        System.out.println("Exiting different groups (Magnet, RollerCoaster No Name) ...");
        attractions[1].rateAndExit(1, 5);
        attractions[1].rateAndExit(1, 4); // 1 is now a different index
        // attractions[1].printVisitors();
        attractions[4].rateAndExit(2, 2);
        attractions[4].rateAndExit(3, 3);
        // attractions[4].printVisitors();

        System.out.println("\n\n\n");

        System.out.println("(No Name, RollerCoaster Jjjjjjjjjjj) remain fully occupied");
        attractions[3].printVisitors();
        attractions[5].printVisitors();
        System.out.println("\nShowing all contents:");
        for (int i = 0; i < attractions.length; i++) {
            System.out.println("Attraction " + i + ":" + attractions[i].toString());
            attractions[i].printVisitors();
            System.out.println();
        }

        System.out.printf("Thetraction and RollerCoaster Raleigh have the same rating: %B%n",
                attractions[0].averageRating() == attractions[2].averageRating());
        System.out.printf("Magnet and RollerCoaster No Name have different ratings: %B%n",
                attractions[1].averageRating() != attractions[3].averageRating());

        System.out.printf("Comparing to same rating and same admissionFee is 0: %B%n",
                attractions[0].compareTo(attractions[2]) == 0);

        System.out.printf("Comparing to lower rating and same admissionFee is +: %B%n",
                attractions[1].compareTo(attractions[0]) > 0);

        System.out.printf("Comparing to higher rating and same admissionFee is -: %B%n",
                attractions[2].compareTo(attractions[1]) < 0);

        System.out.printf("Comparing to same rating and lower admissionFee is +: %B%n",
                attractions[5].compareTo(attractions[3]) > 0);

        System.out.printf("Comparing to null is -: %B%n",
                attractions[5].compareTo(null) < 0);
    }
}
