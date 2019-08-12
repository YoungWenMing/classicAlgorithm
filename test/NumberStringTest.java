import org.junit.Test;

import static org.junit.Assert.*;

public class NumberStringTest {

    @Test
    public void isNumber() {
        String s = "123";
        System.out.println(s + " is a number : " + NumberString.isNumber(s));

        s = "+.123";
        System.out.println(s + " is a number : " + NumberString.isNumber(s));

        s = ".123e10";
        System.out.println(s + " is a number : " + NumberString.isNumber(s));
        System.out.println(s);
    }

    @Test
    public void TestIsNumber(){
        assertTrue(! NumberString.isNumber("++1"));
        assertTrue(NumberString.isNumber("3.45e+10"));
        assertTrue(! NumberString.isNumber(".e"));
        assertTrue(! NumberString.isNumber("0x89"));
        assertTrue(! NumberString.isNumber("1.1e10.1"));
    }


    @Test
    public void TestIsValidNumber(){
        assertTrue(!NumberString.isValidNumber("++1"));
        assertTrue(NumberString.isValidNumber("1e10"));
        assertTrue(NumberString.isValidNumber(".1231"));
        assertTrue(NumberString.isValidNumber("3.4e+10"));
    }

}