import java.util.Arrays;
import java.util.Scanner;

public class Juice {

    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), s = scanner.nextInt();
        int[] vols = new int[n];
        for (int i=0; i < n; i++)
            vols[i] = scanner.nextInt();


        int min = vols[0];
        for (int i= 1; i < n; i ++)
            if (vols[i] < min)  min = vols[i];

        for (int i = n - 1; i > 0; i --){
            s -= (vols[i] - min);
        }

        if (s <= 0) System.out.println(min);
        else {
            int rounds = s / n;
            min = s % n == 0? min - rounds: min -rounds - 1;
            if (min < 0) System.out.println(-1);
            else         System.out.println(min);
        }

    }

}
