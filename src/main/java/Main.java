import java.util.List;

/**
 * Created by mojtab23 on 9/25/16.
 */
public class Main {


    public static void main(String[] args) {
        if (args.length > 0) {
            run(args[0]);
        } else {
            showUsage();
            run("/test.txt");
        }
    }

    private static void run(String arg) {
        Compiler compiler = new Compiler();
        String file = compiler.readFile(arg);
        List<Token> tokens = compiler.tokenizer(file);
        compiler.showTokens(tokens);
    }

    private static void showUsage() {
        System.out.println("call this with file path as argument.");
        System.out.println("using the default test.txt");
    }


}
