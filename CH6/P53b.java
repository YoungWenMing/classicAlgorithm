import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P53b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt(), nums[] = new int[n];
        for (int i =0; i < n;i++)
            nums[i] = scanner.nextInt();
        int start = 0, end = n - 1, mid;
        while (start <= end){
            mid = (start + end) / 2;
            if (mid == nums[mid])   start = mid + 1;
            else                    end = mid - 1;
        }
        System.out.println(start);

    }

}
