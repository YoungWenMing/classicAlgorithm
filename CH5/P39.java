import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class P39 {

    public static int masterNum(int[] array){
        if (array ==null || array.length == 0)
            throw new IllegalArgumentException();
        return masterNum(array, 0, array.length - 1);
    }

    private static int masterNum(int[] array, int start, int end){
        int pivot = array[start];
        int p1 = start + 1, p2 = end, mid = array.length / 2;
        while (p1 < p2){
            while (p1 <= end&& array[p1] <= pivot)  p1++;
            while (p2 >= start && array[p2] > pivot)   p2--;
            if (p1<p2){
                int t = array[p1]; array[p1] = array[p2];array[p2] = t;
            }
        }
        array[start] = array[p2]; array[p2] = pivot;
        if (p2 == mid)  return pivot;
        else if (p2 < mid)  return masterNum(array, p2 + 1, end);
        else                return masterNum(array, start, p2 - 1);
    }


    public static void main(String[] args) {
        int[] a1 = new int[]{2, 1, 1, 2, 2, 2, 2, 2};
        int[] a2 = new int[]{2};
        int[] a3 = new int[]{3,3,3,3,3,2,1};
        int[] a4 = new int[]{2, 1, 1, 1, 2, 2, 2, 2, 2};
        int[] a5 = new int[]{3,3,3,3,3,2,2,1};
        int[] a6 = new int[]{2, 2};

        System.out.println(masterNum(a1));
        System.out.println(masterNum(a2));
        System.out.println(masterNum(a3));
        System.out.println(masterNum(a4));
        System.out.println(masterNum(a5));
        System.out.println(masterNum(a6));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(9);
        pq.add(3);
        pq.add(0);
        pq.add(15);

        while (!pq.isEmpty())
            System.out.println(pq.poll());
    }

}


