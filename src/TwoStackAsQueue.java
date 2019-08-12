import java.util.Stack;

public class TwoStackAsQueue {

    Stack<Integer> out = new Stack<>(), in = new Stack<>();

    public TwoStackAsQueue(){

    }

    /**
     * add an integer to the tail of this queue
     * @param x
     */
    public void addTail(int x){
        in.push(x);
        if (out.empty())
            moveToOutStack();

    }

    /**
     * delete the first item of this queue
     * if it is already empty, throw a exception
     * @return
     */
    public int deleteHead(){
        if (out.empty())
            moveToOutStack();
        if (out.empty())
            throw new StackOverflowError("no more item in this queue!");
        return out.pop();

    }


    /**
     * move all items from IN stack when
     * OUT stack is already empty
     */
    private void moveToOutStack(){
        while (!in.empty())
            out.push(in.pop());
    }


    public static void main(String[] args){
        TwoStackAsQueue q = new TwoStackAsQueue();
        for (int i = 0; i < 10; i ++)
            q.addTail(i);
        for (int i = 0; i < 10; i ++)
            System.out.print(q.deleteHead() + " ");
        q.addTail(9);
        q.deleteHead();
    }
}
