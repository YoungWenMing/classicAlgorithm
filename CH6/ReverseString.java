import java.util.Stack;

public class ReverseString {

    public static String reverseSentence(String s){
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int start = 0, end = 0, l = s.length();
        while (end <= l){
            if (end == l || s.charAt(end) == ' '){
                stack.push(s.substring(start, end));
                start = ++end;
            }else
                end ++;
        }
        while (!stack.empty())
            builder.append(stack.pop() + ' ');
        return builder.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseSentence(" i like you  "));
        System.out.println(reverseSentence("i like you"));
    }

}
