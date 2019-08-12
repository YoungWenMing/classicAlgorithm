import java.util.Arrays;

public class BubbleSort {

    public int times = 0;

    public void sort(int[] array){
        int i, j, end, l = array.length;
        for (i = 0; i < l; i ++){
            end = l - i - 1;
            for (j = 0; j < end ; j ++){
                if (array[j] > array[j + 1])
                    exch(array, j, j + 1);
            }
        }
    }

    public void sortV2(int[] array){
        int i, j, l = array.length;
        int lastSwap = 0;

        for (i = l - 1; i > 0; i = lastSwap){
            lastSwap = 0;
            for (j = 0; j < i; j ++){
                if (array[j] > array[j + 1]){
                    lastSwap = j + 1;
                    exch(array, j, j + 1);
                }
            }
        }

    }

    private void exch(int[] array, int i, int j){
        times ++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args){
        BubbleSort sorter = new BubbleSort();
        BubbleSort sorter1 = new BubbleSort();
        int[] array = new int[]{9,8,1,2,3,4,11,0,-1,7};
        int[] array2 = new int[]{9,8,1,2,3,4,11,0,-1,7};

        sorter.sort(array);
        sorter1.sortV2(array2);


        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

        System.out.println(sorter.times);
        System.out.println(sorter1.times);

        System.out.println(array[0]);
    }
}
