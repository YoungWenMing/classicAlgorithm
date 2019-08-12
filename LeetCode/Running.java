import java.util.Scanner;

public class Running {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt(), R = scanner.nextInt();

        double x = R * Math.cos(L/ (R*1.0)), y = R * Math.sin(- L / (R*1.0));
        System.out.printf("%.3f %.3f", x, y);
        System.out.println();
        System.out.printf("%.3f %.3f", x, -y);

        scanner.close();
    }


}
