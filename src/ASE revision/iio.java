import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class iio {
    static String[] asdf = {"a", "b", "c"};
    static void writelines(String path, String[] arr) throws FileNotFoundException{
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            for (int i = 0; i < asdf.length; i++) {
                writer.println(asdf[i]);
            }
        } finally {
            writer.close();
        }
    }
    public static void main(String[] args) {
        try {
            writelines("test.txt", asdf);
        } catch (FileNotFoundException e) {
            System.out.println("reeeee");
        }

    }
}
