import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

public class DigitSumTest {



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getdigitsum() {
        assertEquals(DigitSum.getdigitsum(0), 0);
        assertEquals(DigitSum.getdigitsum(1111), 4);
        assertEquals(DigitSum.getdigitsum(789), 24);

    }

    @Test
    public void testGetArrayDigitSum(){
        int[] array = new int[]{12, 34, 56};
        assertEquals(DigitSum.getArrayDigitSum(array), 21);
    }

    @Test
    public void testGetNeighbors(){
        int[] pos = new int[]{2, 2};
        int[][] neighbors = PathInMatrix.getNeighborPos(pos);
        for (int i = 0; i < 4; i ++)
            System.out.println(Arrays.toString(neighbors[i]));
    }
}