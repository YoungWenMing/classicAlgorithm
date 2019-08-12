import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    Matrix matrix;
    @Before
    public void setUp() throws Exception {
        matrix = new Matrix(3, 3);
    }

    @Test
    public void transCoordinates() {
        int[] c = matrix.transCoordinates(5);
        //System.out.println(c[0] + " " + c[1]);
        assertEquals(c[0], 1);
        assertEquals(c[1], 2);
    }
}