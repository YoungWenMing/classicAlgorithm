import java.util.Arrays;
import java.util.Random;

public class MiddleNumber {

    public static int find(int[] intStream){
        if (intStream.length == 0)      throw new IllegalArgumentException();
        boolean side = false;
        Heap left = new Heap();
        MinHeap right = new MinHeap();
        int temp, i;
        left.add(intStream[0]);
        for (int j = 1; j < intStream.length; j ++){
            //int l =
            i = intStream[j];
            if (side){
                // can not put to the left directly as it is larger than every left integer
                if (right.size() > 0 && right.getFirst() < i){
                    temp = right.removeFirst();
                    right.add(i);
                    i = temp;
                }
                left.add(i);
            }else {
                if (left.size() > 0 &&  left.getFirst() > i){
                    temp = left.removeFirst();
                    left.add(i);
                    i = temp;
                }
                right.add(i);
            }

            side = !side;
        }
        if (!side)      return left.getFirst();
        else            return (left.getFirst() + right.getFirst()) / 2;
    }

    public static void main(String[] args){
        Random random = new Random();
        int[] ints = new int[11];
        for (int i = 0; i < 11; i ++)
            ints[i] = random.nextInt(200);

        System.out.println(find(ints));
        System.out.println(Arrays.toString(ints));

        ints = new int[]{1};
        System.out.println(find(ints));
    }
}
