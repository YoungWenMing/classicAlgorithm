import java.util.Arrays;

public class P40 {

    public static int[] findFirstKNum(int[] array, int k){
        int l ;
        if (array==null || array.length == 0 || k <= 0)
            throw new IllegalArgumentException();
        if ((l = array.length) <= k)     return array;

        findFirstKNum(array, k, 0, l - 1);

        int result[] = new int[k];
        for (int i = 0; i < k;i ++)
            result[i] = array[i];
        return result;
    }

    private static void findFirstKNum(int[] array, int k, int start, int end){
        int p1 = start + 1, p2 = end, pivot = array[start];
        while (p1 < p2){
            while (p1 <= end && array[p1] <= pivot)     p1++;
            while (p2 >= start && array[p2] > pivot)    p2--;
            if (p2 > p1){
                int t = array[p1]; array[p1] = array[p2]; array[p2] = t;
            }
        }
        array[start] = array[p2]; array[p2] = pivot;
        int target = start + k - 1;
        if (p2 == target)   return ;
        else if (p2 < target)   findFirstKNum(array, target - p2, p2 + 1, end);
        else                    findFirstKNum(array, k, start, p2 - 1);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 1, 1, 2, 2, 2, 2, 2};
        int[] a2 = new int[]{2};
        int[] a3 = new int[]{3,3,3,3,3,2,1};
        int[] a4 = new int[]{2, 1, 1, 1, 2, 2, 2, 2, 2};
        int[] a5 = new int[]{3,3,3,3,3,2,2,1};
        int[] a6 = new int[]{2, 2};


        System.out.println(Arrays.toString(findFirstKNum(a1, 3)));
        System.out.println(Arrays.toString(findFirstKNum(a2, 3)));
        System.out.println(Arrays.toString(findFirstKNum(a3, 3)));
        System.out.println(Arrays.toString(findFirstKNum(a4, 3)));
        System.out.println(Arrays.toString(findFirstKNum(a5, 8)));

    }
}
