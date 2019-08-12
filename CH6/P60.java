import java.util.Arrays;
import java.util.Scanner;

public class P60 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        double[][] prob = new double[N + 1][N * 6  + 1];
        for (int i = 1; i <= 6; i ++)
            prob[1][i] = 1.0 / 6;

        for (int i = 2; i <= N; i ++){
            for (int j = i; j <= 6 * i; j ++){
                for (int k = j - 1; k >= 1 && k >= j - 6; k --)
                    prob[i][j] += prob[i - 1][k];
                prob[i][j] *= 1.0 / 6;
            }
        }

    }
}
