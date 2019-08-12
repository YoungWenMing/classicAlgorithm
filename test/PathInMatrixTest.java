import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PathInMatrixTest {

    PathInMatrix pm ;
    @Before
    public void setUp() throws Exception {
        char[][] matrix = new char[4][4];
        matrix[0] = new char[]{'i', 'l', 'i', 'k'};
        matrix[1] = new char[]{'e', 'w', 'u', 'w'};
        matrix[2] = new char[]{'e', 'n', 'y', 'a'};
        matrix[3] = new char[]{'v', 'e', 'r', 'y'};
        pm = new PathInMatrix(matrix);
    }

    @Test
    public void getItem() {
    }

    @Test
    public void getItem1() {
    }

    @Test
    public void getNeighborPos() {
    }

    @Test
    public void getCoordinates() {
    }

    @Test
    public void isValidPos() {
    }

    @Test
    public void getPath() {
        int[] path = pm.getPath(1, "lwny");
        System.out.println(Arrays.toString(path));

        path = pm.getPath(1, "l");
        System.out.println(Arrays.toString(path));

        path = pm.getPath(1, "xxx");
        System.out.println(Arrays.toString(path));

        path = pm.getPath(1, "lwli");
        System.out.println(Arrays.toString(path));
    }


    @Test
    public void TestRobotMoveRange(){
        assertEquals( pm.robotMoveRange(0), 1);
        assertEquals(pm.robotMoveRange(1), 3);
        assertEquals(pm.robotMoveRange(6), 16);
    }

    @Test
    public void TestRobotMoveRangeSimple(){
        assertEquals(pm.robotMoveRangeSimple(6), 16);
    }
}