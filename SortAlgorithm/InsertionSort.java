import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] array){
        int i, j, l = array.length;
        for (i = 0; i < l - 1; i ++){
            j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                exch(array, j, j - 1);
                j --;
            }
        }
    }

    private static void exch(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args){
        int[] array = new int[]{9,8,1,2,3,4,11,0,-1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
