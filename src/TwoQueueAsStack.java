import java.util.concurrent.ConcurrentLinkedQueue;

public class TwoQueueAsStack {

    ConcurrentLinkedQueue<Integer> nextOutQue = new ConcurrentLinkedQueue<>(),
                                     idle = new ConcurrentLinkedQueue<>();

    public TwoQueueAsStack(){

    }

    public void push(int x){
        nextOutQue.add(x);
    }

    public int pop(){
        if (nextOutQue.isEmpty())
            throw new IndexOutOfBoundsException("no more item in this stack");
        int x;
        while (true){
            x = nextOutQue.poll();
            if (nextOutQue.isEmpty())
                break;
            else
                idle.add(x);
        }
        switchQueues();
        return x;
    }

    private void switchQueues(){
        Object x = nextOutQue;
        nextOutQue = idle;
        idle = (ConcurrentLinkedQueue) x;
    }

    public static void main(String[] args){
        TwoQueueAsStack t = new TwoQueueAsStack();
        t.push(9);
        System.out.println( t.pop());
        for (int i =0; i < 10; i ++)
            t.push(i);
        for (int i = 0; i < 6; i ++)
            System.out.println( t.pop());
        t.push(100);
        for (int i = 0; i < 5; i ++)
            System.out.println( t.pop());

    }
}
