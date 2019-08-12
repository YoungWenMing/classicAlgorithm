import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> temp;
        int i = 0, left, right, k, cmp;
        int l = nums.length;
        for (; i < l; i++){
            k = nums[i];
            if (i > 0 && k == nums[i - 1])  continue;
            left = i + 1;
            right = l - 1;
            while (left < right){

                cmp = k + nums[left] + nums[right];
                if (cmp == 0){
                    temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(nums[left ++]);
                    temp.add(nums[right --]);
                    lists.add(temp);

                    while (left < right && nums[left] == nums[left - 1])
                        left ++;

                    while (left < right && nums[right] == nums[right + 1])
                        right --;

                }
                else if (cmp < 0)  left ++;
                else                right --;
            }

        }
        return (List) lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists)
            System.out.println(Arrays.toString(list.toArray()));

        nums = new int[]{-1, -1, -1, -4, 0 , 2, 1};
        lists = threeSum(nums);
        for (List<Integer> list : lists)
            System.out.println(Arrays.toString(list.toArray()));

        nums = new int[]{-1, -1, -1, -4, 0 , 2, 2, 2, 1};
        lists = threeSum(nums);
        for (List<Integer> list : lists)
            System.out.println(Arrays.toString(list.toArray()));
    }

}
