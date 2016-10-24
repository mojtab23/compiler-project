/**
 * Created by mojtab23 on 10/24/16.
 */
public class Test {

/* output of this class
input text: def variable = 15;
└── declaration_statement
    ├── declaration
    │   ├── type#def
    │   └── identifier#variable
    ├── simple_expression
    │   ├── assignmentOperator#=
    │   └── assignmentLiteral#15
    └── separator#;
 */

    public static void main(String[] args) {
        System.out.println("input text: def myNumber = 15;");

        Token token1 = new Token("def", TokenType.KEYWORD.name());
        Token token2 = new Token("myNumber", TokenType.IDENTIFIER.name());
        Token token3 = new Token("=", TokenType.OPERATOR.name());
        Token token4 = new Token("15", TokenType.NUMBER_LITERAL.name());
        Token token5 = new Token(";", TokenType.SEPARATOR.name());

        ASTNode assignment = ASTNode.getRootNode().addChild("declaration_statement");
        ASTNode declaration = assignment.addChild("declaration");
        ASTNode simple_expression = assignment.addChild("simple_expression");

        assignment.addChild("separator", token5);

        declaration.addChild("type", token1);
        declaration.addChild("identifier", token2);

        simple_expression.addChild("assignmentOperator", token3);
        simple_expression.addChild("assignmentLiteral", token4);

        assignment.print();
    }

}
