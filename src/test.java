

public class test {

    public static void main(String[] args) {
        // Scanner myScanner = new Scanner(System.in);
        // String dataOne = myScanner.next();
        // String dataTwo = myScanner.nextLine();
        // System.out.println(dataOne);
        // System.out.println(dataTwo);
        // myScanner.close();

        // boolean a = true;
        // boolean b = false;
        // if (!a)
        // if (!b)
        //     System.out.println("notb");
        // else
        //     System.out.println("else");
        
        // else System.out.println("a else");

        char letter = 'a';
        switch (++letter) {
            case 'a':
                System.out.println("a");
                break;
            case 'b':
                System.out.println("b");
            default:
                System.out.println("default");
            case 'c':
                System.out.println("c");
                System.out.println(letter);
            case 'd':
                System.out.println("d");
                break;
        }
    }
}
