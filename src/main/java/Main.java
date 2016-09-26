/**
 * Created by mojtab23 on 9/25/16.
 */
public class Main {


    public static void main(String[] args) {
        if (args.length > 0) {
            Compiler compiler = new Compiler();
            compiler.readFile(args[0]);

        } else showUsage();
    }

    private static void showUsage() {
        System.out.println("call this with file path as argument.");
    }

}
