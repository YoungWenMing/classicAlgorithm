import java.util.Arrays;

public class FindDifferentNumbers {

    public static int[] find(int[] array){
        if (array == null || array.length < 2)
            return null;
        int ExclusiveOR = 0;
        for (int i = 0; i < array.length; i++)
            ExclusiveOR ^= array[i];

        // the digit used to distinguish two groups
        int OnePos = 1;
        while ((ExclusiveOR & 1) == 0){
            OnePos ++;
            ExclusiveOR = ExclusiveOR >> 1;
        }
        int p = 0, q = 0;
        for (int i = 0; i < array.length; i ++){
            if (isNdigitZero(array[i], OnePos))
                p ^= array[i];
            else
                q ^= array[i];
        }
        if (p == q)
            return null;
        return new int[]{p, q};
    }

    private static boolean isNdigitZero(int a, int n){
        while (n > 0)
            a = a >> n--;
        return (a & 1) == 0;
    }

    public static int[] findNumberSum(int[] array, int s){
        if (array == null)      return null;
        int i = 0, j = array.length - 1;
        while (i < j){
            int x = array[i] + array[j];
            if (x == s)   return new int[]{array[i], array[j]};
            else if (x < s)     i ++;
            else                j --;
        }
        return null;
    }


    public static void findConsecutiveSum(int s){
        if (s < 3){
            System.out.println("no suitable sequence!");
            return;
        }
        int i = 1, j = 2;
        double sum = 0;
        while (j < s){
            sum =  0.5 * (i + j) * (j - i + 1);
            if (sum == s){
                for (int k = i; k <= j; k ++)
                    System.out.print(k + " ");
                i ++;
                j ++;
                System.out.println();
            }
            else if (sum < s)   j ++;
            else                i ++;

        }
    }



    public static void main(String[] args){
        int[] a = new int[]{1,3, 4, 5, 6, 3, 4, 1};
        System.out.println(Arrays.toString(find(a)));
        a = new int[]{1,2};
        System.out.println(Arrays.toString(find(a)));
        System.out.println(Arrays.toString(findNumberSum(a, 3)));

        a = new int[]{-2, 2, 4, 6, 9};
        System.out.println(Arrays.toString(findNumberSum(a, 8)));
        System.out.println(Arrays.toString(findNumberSum(a, 16)));

        findConsecutiveSum(12);
    }

}
