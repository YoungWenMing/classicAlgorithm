import java.util.Arrays;

public class Package {

    private static void calcDP(int[] weights, int[] values, int[][] dp){
        int l = weights.length, weight, maxV = dp[0].length -1;
        for (int i = 1; i < l; i ++){
            weight = weights[i];
            //when capacity is less than the new item's weight, no need to update
            for (int j = 0; j < weight && j <= maxV; j ++)
                dp[i][j] = dp[i-1][j];
            //when capacity is larger than the new item's weight, it is possible to update
            for (int j = weight; j <= maxV; j ++){
                // the new maximum value is equal to either the previous round with same items
                // or the previous round with less capacity
                // 这轮的新物品不能增加总价值，就取之前的；可以增加总价值，就是容量减去当前重量在上一轮的最佳
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + values[i]);
            }
        }
    }

    private static void calcDP(int[] weights, int[] values, int[] dp){
        int maxV = dp.length - 1, n = weights.length - 1;
        for (int i  = 1; i <= n; i++){
            for (int cap = maxV; cap >= weights[i];cap--)
                dp[cap] = Math.max(dp[cap - weights[i]] + values[i], dp[cap]);
            System.out.println(Arrays.toString(dp));
        }

    }

    public static void main(String[] args) {
        int[] weights = new int[]{0,4, 7, 2, 1, 9},
                values = new int[]{0,1, 3, 2, 5, 10};
        int[][] dp = new int[6][25];

        calcDP(weights, values, dp);

        for (int[] k : dp)
            System.out.println(Arrays.toString(k));

        System.out.println("********************");
        weights = new int[]{0, 4, 7, 2, 1, 9};
        values = new int[]{0, 1, 3, 2, 5, 10};
        int[] dp0 = new int[4];
        calcDP(weights, values, dp0);
        System.out.println(Arrays.toString(dp0));
    }

}
