import java.util.LinkedList;
import java.util.Queue;

public class UglyNumber {

    public static int findNthNumber(int n){
        if (n <= 0)     throw new IllegalArgumentException("invalid number");
        int[] numbers = new int[n];
        numbers[0] = 1;
        int N2 = 0, N3 = 0, N5 = 0;
        int M2 = 0, M3 = 0, M5 = 0;
        int M = 1;
        for (int i = 1; i < n; i ++){
            while ((M2 = numbers[N2] * 2) <= M)     N2 ++;
            while ((M3 = numbers[N3] * 3) <= M)     N3 ++;
            while ((M5 = numbers[N5] * 5) <= M)     N5 ++;
            M = Math.min(Math.min(M2, M3), M5);
            numbers[i] = M;
        }
        return numbers[n - 1];
    }

    public static void main(String[] args){
        System.out.println(findNthNumber(1));
        System.out.println(findNthNumber(2));
        System.out.println(findNthNumber(3));
        System.out.println(findNthNumber(4));
        System.out.println(findNthNumber(5));
        System.out.println(findNthNumber(7));
        System.out.println(findNthNumber(10));
        System.out.println(findNthNumber(150));
        System.out.println(findNthNumber(1500));
    }

}
