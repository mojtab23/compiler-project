import org.junit.Test;

import java.util.List;

/**
 * Created by mojtab23 on 9/26/16.
 */
public class CompilerTest {
    @Test
    public void tokenizer() throws Exception {
        System.out.println(new Compiler().tokenizer(" ++ - 123 4534       "));
    }


    @Test
    public void testFile() {
        Compiler compiler = new Compiler();
        String file = compiler.readFile("/test.txt");
        List<Token> tokens = compiler.tokenizer(file);
        compiler.showTokens(tokens);
    }



}
