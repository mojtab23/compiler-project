import java.util.List;

/**
 * Created by mojtab23 on 9/25/16.
 */
public class CalcTest {

    private int pointer;
    private int saveIndex;
    private char[] chars;
    private List<String> tokens;


    public CalcTest(int pointer, char[] chars, List<String> tokens) {
        this.pointer = pointer;
        this.chars = chars;
        this.tokens = tokens;
        saveIndex = pointer;
    }
//    public static int checkAndAdd(final int pointer, final char[] chars, final List<String> tokens) {
//
//        return 0;
//    }


    public void start() {
        char c = chars[pointer];
        if (isNumber(c)) {
            numberState();
        } else if (isOperator(c)) {
            operatorState();
        } else if (isSpace(c)) {
            spaceState();
        } else errorState();
    }

    private void spaceState() {
        char c = chars[pointer++];
        if (isSpace(c)) {
            spaceState();
        } else finalState();
    }

    private void operatorState() {
        char c = chars[pointer++];
        if (c == chars[pointer - 1]) {
            operatorState2();
        } else if (isSpace(c)) {
            finalState();
        } else errorState();

    }

    private void operatorState2() {
        char c = chars[pointer++];
        if (isSpace(c)) {
            finalState();
        } else errorState();

    }

    private void numberState() {
        char c = chars[pointer++];
        if (isNumber(c)) {
            numberState();
        } else if (isSpace(c)) {
            finalState();
        } else errorState();

    }

    private void finalState(String className) {
        tokens.add(String.copyValueOf(chars, saveIndex, pointer - saveIndex) + " " + className);
    }

    private void errorState() {

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
