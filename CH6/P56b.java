import java.util.Scanner;

public class P56b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), bits[] = new int[32];
        int t, j, result= 0;
        for (int i = 0; i < N; i ++){
            t = scanner.nextInt();
            for (j = 0; j < 32; j ++){
                if ((t & 1) != 0)   bits[j] ++;
                t = t >> 1;
            }
        }

        for (int i = 31; i >= 0; i --){
            result =  result << 1;
            if (bits[i] % 3 != 0)   result ++;

        }
        System.out.println(result);
    }

}
