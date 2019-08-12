import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MergeSortUpwards {

    static private void subCount(int[] ori, int[] aux, int start, int mid, int end){
        end = Math.min(end, aux.length);
        int i = start, j = mid;

        while (start < end){
            if (j >= end)    aux[start++] = ori[i++];
            else if (i >= mid)   aux[start++] = ori[j++];
            else if (ori[i] <= ori[j])  aux[start++] = ori[i++];
            else {
                //count += (mid - i);
                aux[start++] = ori[j++];
            }
        }

        //return count;
    }

    static public int[] sort(int[] ori){
        if (ori == null || ori.length < 2)  throw new IllegalArgumentException();
        int l = ori.length, i = 1, total = 0;
        int aux[] = new int[l], temp[];
        while (i < l){
            for (int j = 0; j < l; j += 2 * i)
                subCount(ori, aux, j, j + i, j + 2 * i);
            i *= 2;
            temp = aux; aux = ori; ori = temp;
        }
        return ori;
        //System.out.println(Arrays.toString(ori));
        //System.out.println(Arrays.toString(aux));

    }


    public static int[] mergeSort(int[] nums){
        int l = nums.length, aux[] = new int[l],
                i, j, k, mid, end, step = 1;
        while (step < l){
            i = 0;
            for (int start = 0; start < l;  start += 2 * step){
                mid = Math.min(start + step, l);
                end = Math.min( start + 2 * step, l);
                j = start;  k = mid;
                while (j < mid || k < end){
                    if (k == end)   aux[i++] = nums[j++];
                    else if (j == mid) aux[i++] = nums[k++];
                    else if (nums[j] < nums[k]) aux[i++] = nums[j++];
                    else        aux[i++] = nums[k ++];
                }
            }
            int[] temp = aux; aux = nums; nums = temp;
            step *= 2;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 2, 3, 4, 7, 0, 12, 6};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{5, 1};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));

        MergeSortUpwards msu = new MergeSortUpwards();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        };
        MergeSortUpwards msuV2 = (MergeSortUpwards) Proxy.newProxyInstance(
            msu.getClass().getClassLoader(),
        )

    }

}


