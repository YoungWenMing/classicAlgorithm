import java.util.*;

public class ProductArray {

    public static int[] get(int[] base){
        int l = base.length;
        int[] result = new int[l];
        int[] top = new int[l],
                bottom = new int[l];

        top[0] = 1;
        bottom[l - 1] = 1;

        for (int i = 1; i < l; i ++){
            top[i] = top[i - 1] * base[i - 1];
            bottom[l - i - 1] = bottom[l - i] * base[l - i];
        }
        for (int i = 0; i < l; i ++)
            result[i] = top[i] * bottom[i];
        return result;
    }

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(get(array)));
        LinkedList<Integer> l = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

    }

}
