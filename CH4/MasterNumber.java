import java.util.Arrays;

public class MasterNumber {

    public static int find(int[] nums){
        int re = find(nums, 0, nums.length - 1);
        return nums[re];
    }

    private static int find(int[] nums, int start, int end){
        if (end == start)    return start;
        int p1 = start + 1, p2 = end, pivot = nums[start];
        while (p1 <= p2){
            while (nums[p1] <= pivot)    p1++;
            while (nums[p2] > pivot)    p2--;
            if (p1 < p2){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }
        // switch the pivot and last smaller item
        nums[start] = nums[p2];
        nums[p2]    = pivot;
        if (p2 == nums.length / 2)        return p2;
        else if (p2 < nums.length / 2)    return find(nums, p2 + 1, end);
        else                                    return find(nums, start, p2 - 1);
    }


    public static int CountFind(int[] nums){
        int current = nums[0], count = 0;
        for (int i : nums){
            if (current == i)       count ++;
            else if (count == 1)    current = i;
            else                    count --;
        }
        return current;
    }

    public static void exchange(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] FindKNumber(int[] array, int k){
        if (k > array.length || k <= 0)
            throw new IllegalArgumentException("k must be less than or at least equal to array's length");
        FindKNumber(array, k - 1, 0, array.length -1);
        int[] result = new int[k];
        for (int i = 0; i < k; i ++)
            result[i] = array[i];
        return result;
    }

    private static void FindKNumber(int[] array, int k, int start, int end){
        if (end < start)    return;
        int pivot = array[start], p1 = start + 1, p2 = end;
        while (true){
            while (array[p1] <= pivot)      p1 ++;
            while (array[p2] > pivot)       p2 --;
            if (p1 < p2 )           exchange(array, p1++, p2 --);
            else break;
        }
        exchange(array, start, p2);
        if (p2 == k)        return;
        else if (p2 < k)    FindKNumber(array, k, p2 + 1, end);
        else                FindKNumber(array, k, start, p2 -1);
    }


    public static void main(String[] args){
        int[] ints = new int[]{6,8,6,4,6,9,6,7,2,6, 7, 6, 8, 6, 6, 3, 6};
        int[] array = new int[]{2, 3, 2, 4, 2};
        System.out.println(find(ints));
        System.out.println(CountFind(ints));

        int[] array2least = FindKNumber(ints, 5);
        System.out.println(Arrays.toString(array2least));

    }

}
