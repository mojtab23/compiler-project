import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mojtab23 on 9/26/16.
 */
public class CompilerTest {
    @Test
    public void tokenizer() throws Exception {
        System.out.println(new Compiler().tokenizer(" ++ - 123 4534       "));
    }


    @Test
    public void testFile() {
        Compiler compiler = new Compiler();
        String file = compiler.readFile("/test.txt");
        List<Token> tokens = compiler.tokenizer(file);
        compiler.showTokens(tokens);
    }

    @Test
    public void tesss() throws Exception {
        System.out.println(tokenize("d-"));

    }

    public List<Token> tokenize(String inputData) {
        int pointer = 0;
        List<Token> tokenList = new ArrayList<>();
        while (true) {
            if ((pointer >= 0) && (pointer < inputData.length())) {
                pointer = addNextToken(inputData, tokenList);
                inputData = inputData.substring(pointer + 1);
            } else
                break;
        }
        return tokenList;
    }

    private int addNextToken(String inputData, List<Token> tokenList) {
//		Your code goes here!
//		Extract the next token from inputData and add it to tokenList
//		The return value refers to the end of next token in inputData
        String substring = inputData.substring(0, 1);
        System.out.println(substring);
        tokenList.add(new Token(substring, "<test>"));
        return 0;
    }

}
