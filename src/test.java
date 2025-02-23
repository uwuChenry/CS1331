

public class test {
    private int[] data;
    public test(int[] values) {
        data = values;
    }
    public static void main (String[] args) {
        test ex1 = new test(new int[]{1,2,3});
        test ex2 = new test(ex1.data);
        ex1.data[0] = 9;
        ex2.data[1] = 6; 
        System.out.println(ex1.data[0] + " " + ex1.data[1] + " " + ex1.data[2]);
        System.out.println(ex2.data[0] + " " + ex2.data[1] + " " + ex2.data[2]);
    }
}
