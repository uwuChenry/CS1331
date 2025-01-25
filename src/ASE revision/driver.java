public class driver {
    public static void main(String[] args) {
        int revenue = 300; 

        if (revenue > 50) {
           if (revenue < 100)
               System.out.println("Revenue is greater than 50"); 
               System.out.println("If block!");
        }  
        else if (revenue > 100) {
            System.out.println("Revenue is greater 100"); 
            System.out.println("Else-if block!");
        }
        else { 
           System.out.println("We have revenue!");
           System.out.println("Else block!");
        }
    }
}
