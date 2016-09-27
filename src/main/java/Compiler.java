import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mojtab23 on 9/25/16.
 */
public class Compiler {


    public String readFile(final String filePath) {
        try {
            Path path = Paths.get(getClass().getResource(filePath).toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException e) {
            System.err.println("Error reading file: \"" + filePath + "\"");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Token> tokenizer(final String input) {

        int pointer = 0;
        char[] chars = input.toCharArray();
        List<Token> tokens = new ArrayList<>();

        while (pointer < chars.length) {

            pointer = checkAndAdd(pointer, chars, tokens);

        }

        return tokens;
    }

    private int checkAndAdd(final int pointer, final char[] chars, final List<Token> tokens) {
//        your code goes here! ###################        //

        return 0;
//        ###################        //
    }

    public void showTokens(List<Token> tokens) {
        tokens.forEach(System.out::println);
    }
}
