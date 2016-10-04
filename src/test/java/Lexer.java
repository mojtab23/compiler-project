import java.util.ArrayList;
import java.util.List;

/**
 * Created by mojtab23 on 9/25/16.
 */
public class Lexer {
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
    }
}
