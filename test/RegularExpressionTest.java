import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionTest {

    @Test
    public void match() {
        RegularExpression R = new RegularExpression("aaaa");
        assertTrue(R.match("aaaa"));
        assertTrue(!R.match("aaa"));

        R = new RegularExpression("a.b*c");
        assertTrue(R.match("aabc"));
        assertTrue(R.match("abbbbbbbbbc"));
        assertTrue(!R.match("aaac"));

        R = new RegularExpression("");
        assertTrue(R.match(""));

        //R = new RegularExpression("aaba*");
        //assertTrue(R.match("aabaaaaaaa"));

    }

    @Test
    public void testMatch(){
        assertTrue(RegularExpression.match("aaba*", "aabaaaaa"));
        assertTrue(RegularExpression.match("aa.a*", "aabaaaaa"));
        assertTrue(RegularExpression.match("ac*bbbi", "abbbi"));
        assertTrue(! RegularExpression.match("ac*b.bi", "acccbbb"));
        assertTrue(RegularExpression.match(".", "a"));
    }
}