import java.util.Arrays;

public class ReversePairCount {

    static private int subCount(int[] ori, int[] aux, int start, int mid, int end){
        end = Math.min(end, aux.length);
        int i = start, j = mid, count = 0;

        while (start < end){
            if (j >= end)    aux[start++] = ori[i++];
            else if (i >= mid)   aux[start++] = ori[j++];
            else if (ori[i] <= ori[j])  aux[start++] = ori[i++];
            else {
                count += (mid - i);
                aux[start++] = ori[j++];
            }
        }
        return count;
    }

    static public int count(int[] ori){
        if (ori == null || ori.length < 2)  throw new IllegalArgumentException();
        int l = ori.length, i = 1, total = 0;
        int aux[] = new int[l];
        while (i <= l){
            for (int j = 0; j < l; j += 2 * i)
                total += subCount(ori, aux, j, j + i, j + 2 * i);
            i *= 2;
            int[] temp = aux; aux = ori; ori = temp;
        }
        System.out.println(Arrays.toString(ori));
        System.out.println(Arrays.toString(aux));
        return total;
    }

    public static void main(String[] args){
        int[] array = new int[]{5, 1, 2, 3, 4, 7, 0, 12, 6};
        System.out.println(count(array));
    }

}
