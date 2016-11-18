import java.util.Stack;

/**
 * Created by mojtab23 on 11/18/16.
 */
public class SymbolTable {

    private final static Scope SCOPE = new Scope();
    private Stack<SymbolTableMember> stack;

    public SymbolTable() {
        stack = new Stack<>();
        stack.push(SCOPE);
    }

    public void enterScope() {
        stack.push(SCOPE);
    }

    public void exitScope() {
        boolean doo;
        do {
            SymbolTableMember pop = stack.pop();
            doo = pop.isVariable();
        } while (doo);
    }

    public void addSymbol(String type, String name) {
        stack.push(new Variable(type, name));
    }

    public boolean checkSymbol(String type, String name) {
        int scopePosition = stack.search(SCOPE);
        int i = stack.search(new Variable(type, name));
        return i != -1 && i < scopePosition;
    }

    public Variable findSymbol(String name) {
        int i = stack.lastIndexOf(new Variable(null, name));
        return (Variable) stack.get(i);
    }


    interface SymbolTableMember {
        boolean isVariable();
    }

    public static class Scope implements SymbolTableMember {
        @Override
        public boolean isVariable() {
            return false;
        }

        @Override
        public String toString() {
            return "Scope{}";
        }
    }

    public class Variable implements SymbolTableMember {

        String type;
        String name;

        public Variable(String type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Variable{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean isVariable() {
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Variable variable = (Variable) o;

            return (type == null || type.equals(variable.type)) && name.equals(variable.name);

        }

        @Override
        public int hashCode() {
            int result = type.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }
    }

}
