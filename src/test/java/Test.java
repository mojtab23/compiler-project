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
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addSymbol("int", "one");
        symbolTable.enterScope();
        symbolTable.addSymbol("bool", "asdf");
        symbolTable.addSymbol("bool", "two");
        symbolTable.addSymbol("bool", "three");
        symbolTable.enterScope();
        symbolTable.addSymbol("bool", "one");
        symbolTable.exitScope();
        System.out.println(symbolTable.checkSymbol("bool", "three"));
        System.out.println(symbolTable.findSymbol("one"));


        SymbolTable.Variable one = symbolTable.findSymbol("one");
        if (one != null) {
            System.out.println(one.name + " " + one.type);
        }

    }

}
