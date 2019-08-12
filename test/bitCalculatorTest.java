import org.junit.Test;

import static org.junit.Assert.*;

public class bitCalculatorTest {

    @Test
    public void countBinaryOne() {
        System.out.println(bitCalculator.countBinaryOne(0));
        assertEquals(bitCalculator.countBinaryOne(8), 1);
        assertEquals(bitCalculator.countBinaryOne(0xffff), 16);
    }

    @Test
    public void TestCountBinaryOneEasy(){
        assertEquals(bitCalculator.countBinaryOneEasy(0xffff), 16);
        assertEquals(bitCalculator.countBinaryOneEasy(0xffffffff), 32);
        assertEquals(bitCalculator.countBinaryOneEasy(0x80000000), 1);
    }
}