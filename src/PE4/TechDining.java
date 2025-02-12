package PE4;
import java.util.Random;

public class TechDining {
    public static Food[] createMeal(int lengthMeal) {
        Food[] meal = new Food[lengthMeal];
        Random rand = new Random();
        for (int i = 0; i < lengthMeal; i++) {
            rand.nextInt(6);
            meal[i] = Food.values()[rand.nextInt(6)];
        }
        return meal;
    }

    public static Food[][] createOrder(int lengthOrder) {
        Food[][] output = new Food[lengthOrder][lengthOrder];
        int counter = 0;
        for (int i = lengthOrder; i > 0; i--) {
            // System.out.println(i);
            Food[] meal = createMeal(i);
            // for (Food thing : meal) {
            //     System.out.println(thing);
            // }
            output[counter] = meal;
            counter++;
        }
        return output;
    }
    public static int mealCost(Food[] meal) {
        int cost = 0;
        // System.out.println(" meal ---------------------");
        for (int i = 0; i < meal.length; i++) {
            cost += i * meal[i].ordinal();
            // System.out.println(meal[i]);
            // System.out.println(i);
            // System.out.println(meal[i].ordinal());
        }
        // System.out.println("total: " + cost);
        return cost;
    }

    public static int orderCost(Food[][] order) {
        int cost = 0;
        for (int i = 0; i < order.length; i++) {
            cost += mealCost(order[i]);
        }
        return cost;
    }

}
