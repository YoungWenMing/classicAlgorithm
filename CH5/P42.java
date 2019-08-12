import java.util.Arrays;
import java.util.Random;

/*
* this problem is the No.42 in that book
* to find the maximum sum of subsequence in a sequence with both
* negative integer and positive integer
* */
public class P42 {

    public static int method1(int[] array){
        if (array == null || array.length == 0)
            throw new IllegalArgumentException();
        int l = array.length, currentSum = array[0], maxSum = currentSum, t;
        for (int i = 1; i < l;i++){
            t = array[i];
            if (currentSum <=0 || t + currentSum <= 0)        currentSum = t;
            else                        currentSum += t;
            if (maxSum < currentSum)    maxSum = currentSum;
        }
        return maxSum;
    }

    public static void main(String[] args){
        int array[] = new int[]{24, -46, 0, -24, -28, 46, -17, 34, -6, -40};
        System.out.println(method1(array));

        int n = 10, l =50;
        array = new int[n];
        Random random = new Random(47);
        for (int j = 0; j < 10; j ++) {
            for (int i = 0; i < n; i++)
                array[i] = random.nextInt(l) - l / 2;
            System.out.println(Arrays.toString(array));
            System.out.println(method1(array));
        }
    }


}
