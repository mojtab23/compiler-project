import java.util.List;


/**
 * Created by mojtab23 on 10/3/16.
 */
public class Parser {
    private int errorLine;
    private List<Token> tokenList;
    private int next;
    private ASTNode rootNode;

    public boolean parse(List<Token> tokenList) {
        this.tokenList = tokenList;
        next = 0;
        rootNode = ASTNode.getRootNode("ROOT");
        boolean success = program();
        if (success)
            return true;
        System.out.println("Parsing error at line: " + errorLine);
        return false;
    }

    private boolean program() {
        ASTNode thisNode = rootNode.addChild("program", 0);
        boolean b = term("int", TokenType.KEYWORD, thisNode, 0) && term("main", TokenType.KEYWORD, thisNode, 1)
                && term("(", TokenType.SEPARATOR, thisNode, 2) && term(")", TokenType.SEPARATOR, thisNode, 3)
                && term("{", TokenType.SEPARATOR, thisNode, 4) && E(5, thisNode) && term("}", TokenType.SEPARATOR, thisNode, 6);
        boolean c = tokenList.size() == next;
        return b && c;

//        return term("int", TokenType.KEYWORD, thisNode, 0) && term("main", TokenType.KEYWORD, thisNode, 1)
//                && term("(", TokenType.SEPARATOR, thisNode, 2) && term(")", TokenType.SEPARATOR, thisNode, 3)
//                && term("{", TokenType.SEPARATOR, thisNode, 4) && E(5, thisNode) && term("}", TokenType.SEPARATOR, thisNode, 6);
    }

    private boolean E(int childIndex, ASTNode currentNode) {
        // continue from here.
        // return true or false;
        return true;
    }

    /**
     * for constant tokens like (if)
     *
     * @param token
     * @param tokenType
     * @return
     */
    private boolean term(String token, TokenType tokenType, ASTNode currentNode, int childIndex) {

        Token nextToken = tokenList.get(next);
        currentNode.addChild(nextToken.getTokenClass(), nextToken, childIndex);
        if (nextToken.getData().equals(token) && nextToken.getTokenClass().equals(tokenType.name())) {
            next++;
            return true;
        } else {
            errorLine = next;
            next++;
            return false;
        }
    }

    /**
     * for variables like literals and identifiers
     *
     * @param tokenType
     * @return
     */
    private boolean term(TokenType tokenType, ASTNode currentNode, int childIndex) {
        Token nextToken = tokenList.get(next);
        currentNode.addChild(nextToken.getTokenClass(), nextToken, childIndex);
        if (nextToken.getTokenClass().equals(tokenType.name())) {
            next++;
            return true;
        } else {
            errorLine = next;
            next++;
            return false;
        }
    }
}