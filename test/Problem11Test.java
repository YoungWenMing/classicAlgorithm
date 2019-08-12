import org.junit.Test;

import static org.junit.Assert.*;

public class Problem11Test {

    @Test
    public void findMin() {
        int[] array = new int[]{3, 4, 5, 0, 2};
        assertEquals(Problem11.findMin(array), 0);

        array = new int[]{2, 0, 2};
        assertEquals(Problem11.findMin(array), 0);

        array = new int[]{1};
        assertEquals(Problem11.findMin(array), 1);

        array = new int[]{1,2 ,3 ,4 ,5};
        assertEquals(Problem11.findMin(array), 1);

        array = new int[]{1, 0, 1, 1, 1};
        assertEquals(Problem11.findMin(array), 0);


        array = new int[]{1, 1, 2, 0, 0};
        assertEquals(Problem11.findMin(array), 0);

        array = new int[]{2, 2, 3, 0, 0, 1, 1, 1};
        assertEquals(Problem11.findMin(array), 0);
    }
}