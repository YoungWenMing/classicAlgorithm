public class RopeCut {

    public static int maxProduct(int n){
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive");
        int[] products = new int[n + 1];
        return maxProduct(n, products);
    }

    private static int maxProduct(int n, int[] products){
        if (products[n] > 0)
            return products[n];
        // we do not get maximum product yet
        if (n == 1 || n == 2)
            products[n] = 1;
        else {
            int m = 0, s;
            for (int i = 1; i < n ; i++){
                int a = maxProduct(i ,products), b = maxProduct(n - i, products);
                a = a > i ? a:i;
                b = b > n -i? b : n - i;
                s = a * b;
                if(s > m)   m = s;
            }
            products[n] = m;
        }
        return products[n];
    }

    public static int greed(int n){
        if (n <= 1)
            throw new IllegalArgumentException("rope must be longer than 1");
        return n <= 3? n - 1: greedy(n);
    }

    private static int greedy(int n){
        return n <= 4? n : 3 * greedy(n - 3);
    }

    private static int greedyV2(int n){
        int result = 1;
        while (n > 4){
            result *= 3;
            n -= 3;
        }
        return  result * n;
    }

    private static int greedyV3(int n){

        if (n < 0)  return 0;
        if (n < 3)  return n - 1;

        int timesOf3 = n / 3;
        int remain = n % 3;

        if (remain == 1){
            timesOf3 -= 1;
            remain += 3;
        }else if (remain == 0)
            remain = 1;
        return (int) Math.pow(3, timesOf3) * remain;
    }

    public static void main(String[] args){
        System.out.println(greedyV2(6));
        System.out.println(greedyV3(6));
        System.out.println(-1 >> 31);
    }
}
