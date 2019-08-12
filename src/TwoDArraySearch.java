import java.util.Arrays;
import java.util.Random;

public class TwoDArraySearch {


    /**
     * consider n * n 2d-array
     *
     * */
    public static int getUpperRight(int[][] array, int w, int h){
        int lenY = array.length, lenX = array[0].length;
        int y = lenY - h, x = w - 1;
        return array[y][x];
    }

    public static boolean search(int[][] array, int goal){
        int h = array.length, w = array[0].length;
        while (h > 0 && w > 0){
            int upperR = getUpperRight(array, w, h);
            if (goal == upperR)
                return true;
            else if (goal > upperR)
                h --;
            else
                w --;
        }
        return false;
    }


    public static void main(String[] args){
        int[][] array = new int[4][4];
        //Random random = new Random();
        for (int i = 0; i < array.length;i++) {
            for (int j = 0; j < array.length; j++)
                array[i][j] = (i + 1) * (j + 1);
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.printf("\n get upper right item with width %d and height %d: %d", 3, 3, TwoDArraySearch.getUpperRight(array,3, 3));
        System.out.printf("\n get upper right item with width %d and height %d: %d", 2, 3, TwoDArraySearch.getUpperRight(array,2, 3));

        System.out.printf("\n is %d in this array? : %b", 10, TwoDArraySearch.search(array, 10));
        System.out.printf("\n is %d in this array? : %b", 12, TwoDArraySearch.search(array, 12));
    }
}
