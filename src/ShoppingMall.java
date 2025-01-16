public class ShoppingMall{
    //Po Cheng Chen
    // fun fact: i like to do photography

    public static void main(String[] args) {
        int cash = 100;
        double taxRate = 1.13;
        double subTotal = 58.62;
        String name = "Po Cheng Chen";
        double change = cash - subTotal * taxRate;
        int temp = (int)(change * 100);
        double changeTrunc = (double)temp / 100;
        System.out.printf("%s has $ %.2f dollars remaining!\n%s started with %d dollars!", name, changeTrunc, name, cash);
    }
}