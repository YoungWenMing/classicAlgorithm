import java.util.Stack;

public class StackWithMin<T extends Comparable> {

    private Stack<T> stack;
    private Stack<T> minStack;
    private T min;

    public StackWithMin(){
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(T item){
        if (stack.empty() || min.compareTo(item) > 0)
            min = item;
        stack.push(item);
        minStack.push(min);
    }

    public T pop(){
        if (stack.empty())      throw new IndexOutOfBoundsException();
        minStack.pop();
        min = minStack.peek();
        return stack.pop();
    }

    public T getMin(){
        return minStack.peek();
    }

    public static boolean isCompatible(int[] in, int[] out){
        if (in.length != out.length)    return false;
        Stack<Integer> stack = new Stack<>();
        int p1 = 0, p2 = 0;
        stack.push(in[p1 ++]);
        while (p2 < out.length){

            if (stack.peek() == out[p2]){
                stack.pop();
                p2 ++;
            }else if (p1 == in.length)
                return false;
            else
                stack.push(in[p1 ++]);
        }
        return true;
    }

}
