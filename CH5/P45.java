import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class P45 {

    static final StringBuilder b1 = new StringBuilder(),
        b2 = new StringBuilder();

    static public void getMax(int[] array){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new StrComparator());
        for (int i : array)     pq.add(i);
        while (!pq.isEmpty())
            System.out.print(pq.poll());
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        int n = 5, bound = 301;
        int[] array = new int[5];
        for (int i = 0; i < n; i ++)
            array[i] = random.nextInt(bound);
        System.out.println(Arrays.toString(array));
        getMax(array);
        System.out.println();
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
        System.out.println(Integer.toHexString(-1));
        System.out.println();

    }


    static class StrComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            b1.delete(0, b1.length());
            b2.delete(0, b2.length());

            b1.append(o1);
            b1.append(o2);
            b2.append(o2);
            b2.append(o1);

            if (Integer.parseInt(b1.toString()) >= Integer.parseInt(b2.toString()))
                return 1;
            else return -1;
        }
    }


}
