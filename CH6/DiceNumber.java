public class DiceNumber {

    public static void countFreq(int n, int maxValue){
        int p1[] = new int[n * maxValue + 1],
                p2[] = new int[n * maxValue + 1];
        for (int i = 1; i <= maxValue; i ++)
            p1[i] = 1;
        for (int i = 2; i <= n; i ++){
            for (int j = i; j <= i * maxValue; j ++){
                p2[j] = 0;
                for (int k = 1; k <= 6 && j - k >= i -1;k ++)
                    p2[j] += p1[j - k];
            }
            int[] temp = p1; p1 = p2; p2 = temp;
        }

        double[] result = doStatistic(p1, n, maxValue * n);
        for (int i = n, j =0; i <= maxValue * n; i ++)
            System.out.printf("%d : %.5f\n", i, result[j++]);

    }

    private static double[] doStatistic(int[] times, int minValue, int maxValue){
        double sum = 0;
        for (int i = minValue; i <= maxValue; i ++)
            sum += times[i];
        double[] result = new double[maxValue - minValue + 1];
        for (int i = minValue, j =0; i <= maxValue; i ++)
            result[j++] = times[i] / sum;
        return result;
    }

    public static void main(String[] args){
        countFreq(6, 6);
    }

}
