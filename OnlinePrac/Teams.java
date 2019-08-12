import java.util.Scanner;
public class Teams{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum[] = new int[n];
        for(int i = 0; i < n; i ++){
            sum[i] = 0;
            for(int j = 1; j < 5; j ++)
                sum[i] += j * scanner.nextInt();
            sum[i] = sum[i] / 4;
        }

        for(int i = 0; i < n;i++)
            System.out.println(sum[i]);


    }



}