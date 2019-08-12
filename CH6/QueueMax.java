import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class QueueMax {

    /**
     * use a dual ended queue to storage those can be the largest number
     * within a window
     * for example, 7, 8, 5 are numbers in a window, add 7 first, and then 8
     * note that 8 is larger than 7, so 7 can not be the largest one of this window
     * and then 5, 5 has a chance to be the largest of next window, so it must be added
     * to the queue
     *
     * @param array
     * @param width
     * @return
     */
    public static int[] MaxInSlidingWindow(int[] array, int width){
        if (array ==null || width > array.length)
            throw new IllegalArgumentException();
        Deque<Integer> deque = new ArrayDeque<>();
        int head = 0, tail = width - 1, result[] = new int[array.length - width + 1];

        // initialize the deque
        deque.addLast(0);
        for (int i = head + 1;i < width; i ++){
            if (array[i] > array[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        int i ;
        while (true){
            // get the largest number's index
            i = deque.getFirst();
            result[head] = array[i];
            // if the largest number is first item of this window, then remove it
            if (head == i)     deque.removeFirst();
            head ++;
            tail ++;
            if (tail == array.length)
                break;
            // the new tail must be added
            // if it is larger then someone, it replace that one
            // else     it just join the deque
            if (array[tail] > array[deque.getLast()]){
                deque.removeLast();
                if (!deque.isEmpty() && array[tail] > array[deque.getFirst()])
                    deque.removeFirst();
            }
            deque.addLast(tail);
        }
        return result;
    }






    public static void main(String[] args){
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(MaxInSlidingWindow(array, 3)));


        array = new int[]{2, 3, 4, 6, 10, 0};
        System.out.println(Arrays.toString(MaxInSlidingWindow(array, 3)));

        array = new int[]{2, 2, 2, 0, 0, 0};
        System.out.println(Arrays.toString(MaxInSlidingWindow(array, 2)));
        Stack<Integer> x;
    }

}
