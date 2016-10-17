import java.util.ArrayList;
import java.util.List;

/**
 * Created by mojtab23 on 10/17/2016.
 */
public class ASTNode {


    private static ASTNode rootNode;
    private String name;
    private ASTNode parentNode;
    private Token token = null;
    private List<ASTNode> children = new ArrayList<>();

    private ASTNode(ASTNode parent, String name) {
        parentNode = parent;
        this.name = name;
    }

    private ASTNode(ASTNode parent, String name, Token token) {
        parentNode = parent;
        this.name = name;
        this.token = token;
    }

    public static ASTNode getRootNode(String name) {
        if (rootNode == null) {
            rootNode = new ASTNode(null, name);
        }
        return rootNode;
    }

    public ASTNode addChild(String name, int childIndex) {
        ASTNode newNode = new ASTNode(this, name);
        this.children.add(childIndex, newNode);
        return newNode;
    }

    public ASTNode addChild(String name, Token token, int childIndex) {
        ASTNode newNode = new ASTNode(this, name, token);
        this.children.add(childIndex, newNode);
        return newNode;
    }

    public void removeChild(int childIndex) {
        children.remove(childIndex);
    }

    public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1)
                    .print(prefix + (isTail ? "    " : "│   "), true);
        }
    }


}
