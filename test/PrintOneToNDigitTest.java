import org.junit.Test;

import static org.junit.Assert.*;

public class PrintOneToNDigitTest {

    @Test
    public void printAll() {
        for (int i = 0; i < 10; i ++)
            System.out.print(i);
    }

    @Test
    public void TestPrintAll(){
        long t1 = System.currentTimeMillis();
        PrintOneToNDigit p = new PrintOneToNDigit(10);
        p.printAll();
        long t2 = System.currentTimeMillis();

        System.out.printf("it cost %d milliseconds to print 9999999999 numbers", t2 -t1);

    }
}