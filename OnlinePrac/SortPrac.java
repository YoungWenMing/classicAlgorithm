import java.util.Scanner;

public class SortPrac {


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt(), t = 0, x , z;
        int[] nums = new int[N], aux = new int[N], temp;
        for (int i = 0; i < N; i ++ )
            aux[i] = nums[i] = scanner.nextInt();
        for (int i = 0; i < M; i ++){
            t = scanner.nextInt();
            x = scanner.nextInt();
            int j = 1;
            while (j < x) {
                for (int k = 0; k < x; k += 2 * j) {
                    if (t == 1) subCountDown(nums, aux, k, k + j, k + 2 * j, x);
                    else subCount(nums, aux, k, k + j, k + 2 * j, x);
                }
                j *= 2;
                for (int k = 0; k< x; k ++){
                    z = aux[k]; aux[k] = nums[k]; nums[k] = z;
                }
            }
        }
        for (int i = 0; i < N; i ++)
            System.out.print(nums[i] + " ");

    }

    static public int[] sort(int[] ori, int from, int to, int indi){
        //if (ori == null || ori.length < 2)  throw new IllegalArgumentException();
        int l = to - from + 1, i = 1, total = 0;
        int aux[] = new int[l], temp[];
        while (i < l){

            for (int j = 0; j < l; j += 2 * i)
                subCount(ori, aux, j, j + i, j + 2 * i, ori.length);
            i *= 2;
            temp = aux; aux = ori; ori = temp;
        }
        return ori;
        //System.out.println(Arrays.toString(ori));
        //System.out.println(Arrays.toString(aux));

    }

    static private void subCount(int[] ori, int[] aux, int start, int mid, int end, int limit){
        end = Math.min(end, limit);
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

    static private void subCountDown(int[] ori, int[] aux, int start, int mid, int end, int limit){
        end = Math.min(end, limit);
        int i = start, j = mid;

        while (start < end){
            if (j >= end)    aux[start++] = ori[i++];
            else if (i >= mid)   aux[start++] = ori[j++];
            else if (ori[i] >= ori[j])  aux[start++] = ori[i++];
            else {
                //count += (mid - i);
                aux[start++] = ori[j++];
            }
        }
        //return count;
    }

}
