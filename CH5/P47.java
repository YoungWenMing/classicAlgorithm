import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
test case:
4 4
1 10 3 8
12 2 9 6
5 7 4 11
3 7 16 5
*
* this program is used to find the maximum value of a
* value matrix of presents,
* we can only go through this matrix with downside move or
* right turn
* */


public class P47 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] values = new int[m][n];

        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j++)
                values[i][j] = scanner.nextInt();
        // initialization
        for (int i = 1; i < n; i ++)
            values[0][i] += values[0][i - 1];
        for (int i = 1; i < m; i ++)
            values[i][0] += values[i - 1][0];

        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                values[i][j] += Math.max(values[i - 1][j], values[i][j - 1]);
            }
        }

        for (int i = 0; i < m; i ++)
            System.out.println(Arrays.toString(values[i]));


        System.out.println(values[m - 1][n - 1]);
    }


}
