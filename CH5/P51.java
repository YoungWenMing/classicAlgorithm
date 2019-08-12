import java.util.Arrays;
import java.util.Scanner;

public class P51 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), nums[] = new int[n], aux[] = new int[n], temp[];
        for (int i = 0; i < n; i ++)
            nums[i] = scanner.nextInt();

        int window = 2, total = 0, p1, p2, mid, end, start;
        while (window / 2 < n){

            for (int i = 0; i < n; i += window){
                p1 = i;  p2 = i + window / 2;
                start = p1; mid = p2; end = Math.min(i + window, n);
                while (start < end){
                    if (p1 == mid)  {
                        aux[start ++] = nums[p2 ++];
                    }else if (p2 >= end){
                        aux[start ++] = nums[p1++];
                    }else if (nums[p2] >= nums[p1]){
                        aux[start ++] = nums[p1 ++];
                    }else {
                        aux[start ++] = nums[p2 ++];
                        total += (mid - p1);
                    }
                }

            }
            temp = aux; aux = nums; nums = temp;
            window *= 2;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(total);
    }

}
