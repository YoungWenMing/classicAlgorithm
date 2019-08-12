import java.util.Scanner;

public class P63 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), last = scanner.nextInt(),
                low = last, profit = 0, current;
        for (int i = 1; i < N; i ++){
            current = scanner.nextInt();
            if (current > last)
                profit = Math.max(current - low, profit);
            else {
                if (current < low)  low = current;
            }
        }
        System.out.println(profit);
    }

}
