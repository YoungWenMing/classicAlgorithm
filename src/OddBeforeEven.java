import java.util.Arrays;

public class OddBeforeEven {

    public static void move(int[] arrays){
        if (arrays == null || arrays.length == 0)
            throw new IllegalArgumentException();

        int leftP = 0, rightP = arrays.length - 1;
        while (leftP < rightP){
            while (isOdd(arrays[leftP]))    leftP ++;
            while (isEven(arrays[rightP]))   rightP --;
            if (leftP < rightP){
                int temp = arrays[leftP];
                arrays[leftP] = arrays[rightP];
                arrays[rightP] = temp;
            }
        }
    }

    private static boolean isOdd(int x){
        return (x & 1) == 1;
    }

    private static boolean isEven(int x){
        return (x & 1) == 0;
    }

    public static void main(String args[]){
        int[] array = new int[]{1, 2, 4, 5,6, 9, 0, 11};
        System.out.println(Arrays.toString(array));

        move(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{1};
        move(array);
        System.out.println(Arrays.toString(array));
    }

}
