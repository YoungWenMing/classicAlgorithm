import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P59 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), window = scanner.nextInt(),
                nums[] = new int[N];
        for (int i = 0; i < N  ; i ++)
            nums[i] = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        int head = 0, tail = window - 1, t = 0;
        deque.addLast(0);
        for (int i = 1; i <= tail; i ++){
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        String space = " ";
        for (; tail < N;){
            System.out.print(space);
            System.out.print(nums[t = deque.getFirst()]);
            // remove the head if needed
            if (t == head++)  deque.removeFirst();

            // deal with the new item at the end of this window
            if (tail ++ == N - 1)  break;
            if (deque.isEmpty() || nums[tail] > nums[deque.getFirst()]) {
                deque.clear();
                deque.addLast(tail);
            }else {
                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[tail]){
                    deque.removeLast();
                }
                deque.addLast(tail);
            }
        }
    }

}
