import java.util.Scanner;

public class P56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), nums[] = new int[N];
        for (int i = 0; i < N; i ++)
            nums[i] = scanner.nextInt();

        int probe = 0;
        for (int i = 0; i < N; i ++)
            probe ^= nums[i];

        int t = 1;
        while ((probe & t) == 0)
            t = t << 1;

        int num1 = 0, num2 = 0;
        for (int i = 0; i < N ; i ++){
            if ((nums[i] & t ) != 0)    num1 ^= nums[i];
            else                        num2 ^= nums[i];
        }
        System.out.printf("%d %d", num1, num2);
    }

}
