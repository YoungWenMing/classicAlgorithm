import org.junit.Test;

import static org.junit.Assert.*;

public class BitAdditionTest {

    @Test
    public void add() {
        assertEquals(BitAddition.add(1, 3), 4);
        assertEquals(BitAddition.add(-1, 1), 0);

        assertEquals(BitAddition.add(-3, 9), 6);
        assertEquals(BitAddition.add(4, 9), 13);
        assertEquals(BitAddition.add(55, 931), 986);
    }
}