package PE4;

public class Driver {
    public static void main(String[] args) {
        Food[] meal1 = TechDining.createMeal(5);
        Food[] meal2 = TechDining.createMeal(2);
        int cost1 = TechDining.mealCost(meal1);
        int cost2 = TechDining.mealCost(meal2);
        System.out.println("Cost of meal 1: " + cost1);
        System.out.println("Cost of meal 2: " + cost2);
        Food[][] order1 = TechDining.createOrder(3);
        Food[][] order2 = TechDining.createOrder(4);
        int orderCost1 = TechDining.orderCost(order1);
        int orderCost2 = TechDining.orderCost(order2);
        System.out.println("Cost of order 1: " + orderCost1);
        System.out.println("Cost of order 2: " + orderCost2);
    }
}
