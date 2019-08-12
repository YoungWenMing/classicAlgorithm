import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Songs {

    static private long p[][] = new long[101][101];

    static {
        p[0][0] = 1;
        for (int i = 1; i <= 100; i ++){
            p[i][0] = p[i][i] =1;
            for (int j = 1; j < i; j ++)
                p[i][j] = (p[i-1][j-1] + p[i-1][j]) %1000000007;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt(), A = scanner.nextInt(),
                x = scanner.nextInt(), B =scanner.nextInt(),
                y = scanner.nextInt();

        int j;
        long sum = 0;
        for (int i = 0; i <= x; i ++){
            if (i * A > K)              break;
            if ((K - i * A) % B  != 0)  continue;
            if ((j= (K - i * A) / B) > y) continue;

            sum = (sum + (p[x][i] * p[y][j]) % 1000000007)%1000000007;
        }
        System.out.println(sum);



        //System.out.println(Arrays.toString(cA));
        //System.out.println(Arrays.toString(cB));
    }

}
