import java.util.Random;

public class TechDining {
    static Food[] createMeal(int lengthMeal){
        Food[] meal = new Food[lengthMeal];
        Random rand = new Random();
        for (int i = 0; i < lengthMeal; i++) {
            rand.nextInt(6);
            meal[i] = Food.values()[rand.nextInt(6)];
        }
        return meal;
    }
    static Food[][] createOrder (int lengthOrder){
        Food[][] output = new Food[lengthOrder][lengthOrder];
        int counter = 0;
        for (int i = lengthOrder; i > 0; i--) {;
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
    static int mealCost(Food[] meal){
        int cost = 0;

        return cost;
    }
    
    static public void main (String[] args){
        Food[][] order = createOrder(3);
        for (int i = 0; i < order.length; i++) {
            System.out.println("Order " + i + ":");
            for (int j = 0; j < order[i].length; j++) {
                System.out.println(order[i][j]);
            }
        }
    }
}
