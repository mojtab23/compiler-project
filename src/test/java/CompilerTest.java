import org.junit.Test;

/**
 * Created by mojtab23 on 9/26/16.
 */
public class CompilerTest {
    @Test
    public void tokenizer() throws Exception {
        System.out.println(new Compiler().tokenizer(" ++ - 123 4534       "));
    }

}