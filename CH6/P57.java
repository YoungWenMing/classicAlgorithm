import java.util.Scanner;

public class P57 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), sum = scanner.nextInt(), nums[] = new int[N];
        int i = 0, j = N - 1, cmp;
        for (int k = 0; k < N; k ++)
            nums[k] = scanner.nextInt();

        while (i < j){
            cmp = nums[i] + nums[j] - sum;
            if (cmp == 0)   break;
            else if (cmp < 0)   i ++;
            else                j --;
        }
        System.out.printf("%d, %d", nums[i], nums[j]);
    }

}
