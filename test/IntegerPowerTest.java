import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerPowerTest {

    @Test
    public void power() {
        //assertEquals(IntegerPower.power(2, 0), 1.0);
        //assertEquals(IntegerPower.power(2, -1), 0.5);
        System.out.println(IntegerPower.power(2, -1));
        System.out.println(IntegerPower.power(2, 0));
        System.out.println(IntegerPower.power(2, 3));
        System.out.println(IntegerPower.power(2, 20));
    }
}