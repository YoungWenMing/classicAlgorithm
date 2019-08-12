import java.util.Arrays;
import java.util.Scanner;

/*
* this problem is from 360 company
* */
public class GoldDivision {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int gold, golds[], p1, dp[][];

        for (int c = 0; c < cases; c ++){

            gold = scanner.nextInt();
            golds = new int[gold + 1];
            dp = new int[gold + 1][gold + 1];
            for (int i = 1; i <= gold; i ++){
                p1 = scanner.nextInt();
                golds[i] = golds[i-1] + p1;
                dp[i][i] = p1;
            }

            for (int i = gold - 1; i >= 1; i--){
                for (int j = i; j <= gold;j ++){
                    dp[i][j] = golds[j] - golds[i-1] - Math.min(dp[i + 1][j], dp[i][j-1]);
                }
            }
            System.out.printf("Case #%d: %d %d",c + 1, dp[1][gold], golds[gold] - dp[1][gold]);

        }
        scanner.close();
    }

}
