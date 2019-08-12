import java.util.Scanner;

public class P49 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 5){
            System.out.println(n);
            return;
        }
        int T2 = 3, T3 = 2, T5 = 2, nums[] = new int[n + 1];
        for (int i = 1; i <=5; i ++)
            nums[i] = i;
        int M2 = nums[T2], M3 = nums[T3], M5 = nums[T5];

        for (int i = 6; i <=n; i ++){
            nums[i] = Math.min(Math.min(M2 * 2, M3 * 3), M5* 5);
            while (M2 * 2 <= nums[i]){
                T2 ++;
                M2 = nums[T2];
            }
            while (M3 * 3 <= nums[i]){
                T3 ++;
                M3 = nums[T3];
            }
            while (M5 * 5 <= nums[i]){
                T5 ++;
                M5 = nums[T5];
            }
        }

        System.out.println(nums[n]);
    }

}
