import java.util.List;

import static Token.TokenType.*;

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

        return token("int", KEYWORD) && token("main", MAIN) && token("{", SEPARATOR) && expression() && token("}", SEPARATOR);
    }

    private boolean expression() {
        // continue from here.
        return true;
    }

    /**
     * for constant tokens like (if)
     *
     * @param token
     * @param tokenType
     * @return
     */
    private boolean token(String token, Token.TokenType tokenType) {
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
    private boolean token(Token.TokenType tokenType) {
        Token t = tokenList.get(pointer);
        if (t.getTokenClass().equals(tokenType.name())) {
            pointer++;
            return true;
        }
        errorLine = pointer;
        return false;
    }

}
