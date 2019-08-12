
import java.util.Stack;
public class Main {

    final static String ADD = new String("+");
    final static String SUB = new String("-");
    final static String TIMES = new String("*");
    final static String DIV = new String("/");
    final static String NUM = "-?\\d+";


    static public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int x;
        for(int i = 0; i < tokens.length; i ++){


            if(tokens[i].matches(NUM))
                stack.push(Integer.parseInt(tokens[i]));
            else if(ADD.equals(tokens[i])){
                x = stack.pop() + stack.pop();
                stack.push(x);
            }else if(SUB.equals(tokens[i])){
                x = stack.pop();
                x = stack.pop() - x;
                stack.push(x);
            }else if(TIMES.equals(tokens[i])){
                x = stack.pop() * stack.pop();
                stack.push(x);
            }else{
                x = stack.pop();
                x = stack.pop() / x;
                stack.push(x);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(strs));
    }
}
