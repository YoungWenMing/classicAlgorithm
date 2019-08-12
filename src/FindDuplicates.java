import java.util.Arrays;
import java.util.Random;

public class FindDuplicates {
    /**
     * given an array with length n, in which there are integers
     * between 0 and n - 1, find a arbitrary number which has a duplicates
     * in the array
     * */

    /**
     * sort the array first and then check all adjacent integer pair in array one by one
     * */
    public static int find(int[] array){
        selectionSort(array);

        for (int i = 0; i < array.length - 1; i ++)
            if (array[i] == array[i + 1])
                return array[i];
        return -1;
    }

    public static int find2(int[] array){
        int len = array.length;
        int statistic[] = new int[len];
        for (int i = 0; i < len; i ++){
            int j = array[i];
            statistic[j] ++;
            if (statistic[j] > 1)
                return j;
        }
        return -1;
    }


    public static int find3(int[] array){
        /*
        * scan the array, check two items before put
        * an item to where it belong
        * */
        int len = array.length;
        for (int i = 0; i < len; i ++){

            /*keep swapping two items until array[i] equals i
            *
            * */
            while (array[i] != i){
                int a = array[i];
                if (a == array[a])
                    return a;
                array[i] = array[a];
                array[a] = a;
            }
        }
        return -1;
    }

    /*there must be at least 1 duplicates in this array*/
    public static int find4(int[] array){
        int start = 0, end = array.length - 1, mid;
        while (start < end){
            mid = start + (end - start) / 2;
            int a = countItemInterval(array, start, mid),
                    b = countItemInterval(array, mid + 1, end);
            if (a < b)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    private static int countItemInterval(int[] array, int start, int end){
        if (start > end)    return 0;
        int count = 0;
        for (int i =0; i < array.length; i ++){
            if (array[i] <= end && array[i] >= start)
                count ++;
        }
        return count;
    }

    public static void selectionSort(int[] array){
        int len = array.length;
        for (int i = 0; i < len; i ++){
            int a = array[i];
            for (int j = i + 1; j < len; j ++){
                if (a > array[j]){
                    array[i] = array[j];
                    array[j] = a;
                    a = array[i];
                }
            }
        }
    }

    public static void main(String[] args){
        Random random = new Random();
        int n = 30;
        int[] obj = new int[30];
        for (int i = 0; i < n; i ++)
            obj[i] = random.nextInt(n);
        System.out.println(Arrays.toString(obj));
        System.out.println("find it with statistic method: " + FindDuplicates.find2(obj));
        System.out.println("find it with exchange method: " + FindDuplicates.find3(obj));

        int dup = FindDuplicates.find(obj);
        System.out.println("duplicates item in this array include: " + dup);
        System.out.println(Arrays.toString(obj));

        int[] obj2 = new int[n + 1];
        for (int i=0; i < n + 1; i ++)
            obj2[i] = random.nextInt(n);
        System.out.println(Arrays.toString(obj2));
        System.out.println("duplicate item in this array is : " + FindDuplicates.find4(obj2));
        int[] a = {1,2,3,4,5,0,0};
        System.out.println(FindDuplicates.find4(a));
    }

}
