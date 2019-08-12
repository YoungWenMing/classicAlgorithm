public class SelectionSort {

    public static void sort(int[] array){
        if (array == null || array.length <= 1)
            return;
        for (int i = 0; i < array.length; i ++){
            for (int j = i; j > 0 && array[j] < array[j - 1]; j --){
                int temp = array[j]; array[j] = array[j - 1];
                array[j - 1] =temp;
            }
        }
    }

}
