import org.junit.Test;

import static org.junit.Assert.*;

public class RopeCutTest {

    @Test
    public void maxProduct() {
        assertEquals(RopeCut.maxProduct(8), 18);
    }

    @Test
    public void greedTest(){
        assertEquals(RopeCut.greed(8), 18);
    }
}