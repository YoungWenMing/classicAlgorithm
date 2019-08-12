import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void findMinRotation() {
        int[] a = {3, 4, 5, 0, 1, 2};
        int min = BinarySearch.findMinRotation(a);
        assertEquals(min, 0);

        int c = 10;
        Random random = new Random();
        int[] array = new int[c];
        for (int i = 0; i < c; i ++)
            array[i] = random.nextInt(1000);
        Arrays.sort(array);
        min = array[0];
        array = rotate(random.nextInt(9), array);

        assertEquals(min, BinarySearch.findMinRotation(array));
    }


    @Test
    public void testFindMinRotation(){
        int[] array = {7, 8, 9, 9, 0, 3, 5, 6};
        int min = BinarySearch.findMinRotation(array);
        assertEquals(min, 0);
    }

    @Test
    public void find() {
    }

    private static int[] rotate(int n, int[] array){
        int l = array.length;
        int[] newArray = new int[array.length];
        for (int i = 0; i < l; i ++)
            newArray[(i + n) % l] = array[i];
        return newArray;
    }
}