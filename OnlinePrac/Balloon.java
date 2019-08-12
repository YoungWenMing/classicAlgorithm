import java.util.Scanner;

public class Balloon {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1], sums = new int[n+1], digits = new int[10];
        for (int i = 1; i <= n; i ++)
            nums[i] = scanner.nextInt();
        sums[0] = 1;
        scanner.close();

        for (int i = 1; i <= n;i++){
            for (int j = 1; j < 10; j ++)
                digits[j] = 0;

            for (int j = i; j > 0; j --){
                if (++digits[nums[j]] > 1)  break;
                sums[i] = (sums[i] + sums[j - 1]) % 1000000007;
            }
        }
        System.out.println(sums[n]);
    }

}
