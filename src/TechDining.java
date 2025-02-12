import java.util.Random;

public class TechDining {
    static Food[] createMeal(int lengthMeal) {
        Food[] meal = new Food[lengthMeal];
        Random rand = new Random();
        for (int i = 0; i < lengthMeal; i++) {
            rand.nextInt(6);
            meal[i] = Food.values()[rand.nextInt(6)];
        }
        return meal;
    }

    static Food[][] createOrder(int lengthOrder) {
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
    static int mealCost(Food[] meal) {
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

    static int orderCost(Food[][] order) {
        int cost = 0;
        for (int i = 0; i < order.length; i++) {
            cost += mealCost(order[i]);
        }
        return cost;
    }
    public static void main(String[] args) {
        Food[] meal1 = createMeal(5);
        Food[] meal2 = createMeal(2);
        int cost1 = mealCost(meal1);
        int cost2 = mealCost(meal2);
        System.out.println("Cost of meal 1: " + cost1);
        System.out.println("Cost of meal 2: " + cost2);
        Food[][] order1 = createOrder(3);
        Food[][] order2 = createOrder(4);
        int orderCost1 = orderCost(order1);
        int orderCost2 = orderCost(order2);
        System.out.println("Cost of order 1: " + orderCost1);
        System.out.println("Cost of order 2: " + orderCost2);

    }
}
