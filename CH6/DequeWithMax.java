import java.util.ArrayDeque;
import java.util.Deque;

public class DequeWithMax {

    private Deque<Integer> deque, maximums;

    public DequeWithMax(){
        deque = new ArrayDeque<>();
        maximums = new ArrayDeque<>();
    }

    public void push_back(int n){
        deque.addLast(n);
        int i = 1;
        while (!maximums.isEmpty() && maximums.getLast() < n){
            maximums.removeLast();
            i ++;
        }
        while (i > 0){
            maximums.addLast(n);
            i --;
        }
    }

    public int pop_front(){
        if (deque.isEmpty())    throw new IndexOutOfBoundsException("No more items in queue");
        maximums.pop();
        return deque.pop();
    }

    public int max(){
        if (deque.isEmpty())    throw new IndexOutOfBoundsException("No more items in queue");
        return maximums.getFirst();
    }


    public static void main(String[] args){
        DequeWithMax dw = new DequeWithMax();
        dw.push_back(1);
        dw.push_back(3);
        dw.push_back(20);
        dw.push_back(18);

        System.out.println(dw.max());
        System.out.println(dw.pop_front());
        System.out.println(dw.max());
        System.out.println(dw.pop_front());
        System.out.println(dw.pop_front());
        System.out.println(dw.max());
    }

}
