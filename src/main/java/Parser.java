import java.util.List;


/**
 * Created by mojtab23 on 10/3/16.
 */
public class Parser {

    private int errorLine;
    private AST ast = new AST();
    private List<Token> tokenList;
    private int pointer;

    public AST parse(List<Token> tokenList) throws Exception {
        this.tokenList = tokenList;
        pointer = 0;
        if (program()) {
            return ast;
        } else throw new Exception("Error at line: " + errorLine);
    }

    private boolean program() {

        return token("int", TokenType.KEYWORD) && token("main", TokenType.MAIN) &&
                token("{", TokenType.SEPARATOR) && expression() && token("}", TokenType.SEPARATOR);
    }

    private boolean expression() {
        // continue from here.
//        return true;
    }

    /**
     * for constant tokens like (if)
     *
     * @param token
     * @param tokenType
     * @return
     */
    private boolean token(String token, TokenType tokenType) {
        Token t = tokenList.get(pointer);
        if (t.getData().equals(token) && t.getTokenClass().equals(tokenType.name())) {
            pointer++;
            return true;
        }
        errorLine = pointer;
        return false;
    }

    /**
     * for variables like literals and identifiers
     *
     * @param tokenType
     * @return
     */
    private boolean token(TokenType tokenType) {
        Token t = tokenList.get(pointer);
        if (t.getTokenClass().equals(tokenType.name())) {
            pointer++;
            return true;
        }
        errorLine = pointer;
        return false;
    }

}
