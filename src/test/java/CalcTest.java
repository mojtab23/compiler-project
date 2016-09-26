import java.util.List;
import java.util.Optional;

/**
 * Created by mojtab23 on 9/25/16.
 */
public class CalcTest {

    private int pointer;
    private int saveIndex;
    private char[] chars;
    private List<Token> tokens;


    public CalcTest(int pointer, char[] chars, List<Token> tokens) {
        this.pointer = pointer;
        this.chars = chars;
        this.tokens = tokens;
        saveIndex = pointer;
    }
//    public static int checkAndAdd(final int pointer, final char[] chars, final List<String> tokens) {
//
//        return 0;
//    }


    public int start() {
        char c = chars[pointer];
        if (isNumber(c)) {
            numberState();
        } else if (isOperator(c)) {
            operatorState();
        } else if (isSpace(c)) {
            spaceState();
        } else errorState();
        return pointer;
    }

    private void spaceState() {
        Optional<Character> c = nextChar();
        if (c.isPresent() && isSpace(c.get())) {
            spaceState();
        } else finalState("<WhiteSpace>");
    }

    private Optional<Character> nextChar() {
        if (++pointer < chars.length)
            return Optional.of(chars[pointer]);
        else return Optional.empty();
    }

    private void operatorState() {
        Optional<Character> c = nextChar();
        if (c.isPresent()) {
            if (c.get() == chars[pointer - 1]) {
                operatorState2();
            } else if (isSpace(c.get())) {
                finalState("<Operator>");
            } else errorState();
        } else finalState("<Operator>");

    }

    private void operatorState2() {
        Optional<Character> c = nextChar();


        if (c.isPresent()) {
            if (isSpace(c.get())) {
                finalState("<UnaryOperator>");
            } else errorState();
        } else finalState("<UnaryOperator>");
    }

    private void numberState() {
        Optional<Character> c = nextChar();

        if (c.isPresent()) {
            if (isNumber(c.get())) {
                numberState();
            } else if (isSpace(c.get())) {
                finalState("<Number>");
            } else errorState();
        } else finalState("<Number>");


    }

    private void finalState(String className) {
//        String builder = className + " " +
//                String.valueOf(chars, saveIndex, pointer - saveIndex);
//        tokens.add(builder);
        tokens.add(new Token(String.valueOf(chars, saveIndex, pointer - saveIndex), className));

    }

    private void errorState() {
        Optional<Character> c = nextChar();

        if (c.isPresent()) {
            if (isSpace(c.get()) || isNumber(c.get()) || isOperator(c.get())) {
                finalState("<Error>");
            } else errorState();
        } else finalState("<Error>");


    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    private boolean isSpace(char c) {
        return Character.isWhitespace(c);
    }

}
