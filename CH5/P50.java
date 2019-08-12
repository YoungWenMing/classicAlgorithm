import java.util.Scanner;

public class P50 {



    public static void firstCh(){
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine().trim();
        int[] counts = new int[256];

        for (int i = 0; i < target.length(); i ++){
            counts[target.charAt(i)] ++;
        }

        for (int i = 0; i < target.length(); i ++){
            if (counts[target.charAt(i)] == 1) {
                System.out.println(target.charAt(i));
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        firstCh();
    }

}
