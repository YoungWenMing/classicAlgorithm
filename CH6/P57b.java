import java.util.Scanner;

public class P57b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        scanner.close();
        int head = 1, tail = 2, end = s / 2 + 1, cmp;
        while (tail <= end && head < tail){
            cmp = (head + tail) * (tail - head + 1) / 2 - s;
            if (cmp == 0)   {
                for (int i = head; i <= tail; i ++)
                    System.out.print(i + " ");
                head ++;
                tail ++;
            }else if (cmp < 0){
                tail ++;
            }else {
                head ++;
            }
        }
    }

}
