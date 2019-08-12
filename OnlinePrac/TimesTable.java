import java.math.BigInteger;
import java.util.Scanner;


public class TimesTable {


    /*keep m >= n*/
    public static long leftItems(long n, long m, final long j){
        //n = n > m? m: n;
        long i = j;
        if (i > m){
            i = n - (i - m) - 1;
        }
        long h = i >= n? n :i;
        long nums = (2 * i - h + 1) * h / 2;
        return i == j? nums : n * m - nums;
    }


    public static long findLine(long n, long m, long k){
        long mid = 1, start = 1, end = m, counts, sc;

        while (start <= end){
            mid = (start + end) / 2;
            sc = mid >= n? n: mid;
            counts = leftItems(n, m, mid);
            if (counts < k)     start = mid + 1;
            else if (counts == k || counts - sc < k)   break;
            else
                end = mid - 1;
        }

        return mid;

    }

    public static long countSmaller(long rows, long cols, long target){
        long sum = 0;
        for (int i = 1; i <= rows; i ++){
            sum += (i * cols > target)? target / i:cols;
            if (target < i)     break;
        }
        return sum;
    }


    public static long getKthNumber(long rows, long cols, long k){
        long mid, start = 1, end = rows * cols, nums;
        while (start <= end){
            mid = (start + end) / 2;
            nums = countSmaller(rows, cols, mid);
            if (nums < k)   start = mid + 1;
            else if (nums == k)     return mid;
            else            end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args){

        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger k = new BigInteger(scanner.nextLine().trim());
        scanner.close();

        int i = 0, start = 1, thres = m, num = 0;
        BigInteger big = null;


        while(true){
            i ++;
            if (i > thres){
                start ++;
                thres += m;
            }
            for(int j = start; j <= n; j++){
                if(i % j == 0){
                    if (big == null) num  ++;
                    else big.add(new BigInteger("1"));
                }
            }
            if (num == Integer.MAX_VALUE)   big = new BigInteger(Integer.toString(num));
        }*/

        System.out.println( getKthNumber(5, 5, 7));
        Scanner scanner = new Scanner(System.in);
        long rows, cols, k;
        while (scanner.hasNextLong()){
            rows = scanner.nextLong();
            cols = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(getKthNumber(rows, cols, k));
        }

    }


}
