


public class Main{
    static int[] arr = {5, 3, 2, 1, 4};
    public static void main(String[] args) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int asdf : arr) {
            System.out.println(asdf);
        }
    }
}