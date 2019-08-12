import java.util.Scanner;

public class OverSequence {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.close();
        int result = (n / (2 * m)) * (m * m);
        System.out.println(result);
    }

}
