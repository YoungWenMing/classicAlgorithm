import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class P58 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine().trim();
        Stack<Character> stack = new Stack<>();

        int i = target.length() - 1;
        char c, d = ' ';
        while (i >= 0){
            while (i >= 0 && (c = target.charAt(i--)) != d){
                stack.push(c);
            }
            while (!stack.empty())
                System.out.print(stack.pop());
            System.out.println();
        }

    }

}
