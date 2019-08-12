import java.util.Arrays;

public class closeThreeSum {

    public static int find(int[] nums, int target){
        Arrays.sort(nums);
        int dist = Integer.MAX_VALUE, left, right, k, l = nums.length, cmp, t;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < l - 2; i ++){
            k = nums[i];
            left = i + 1;
            right = l - 1;
            while (left < right){
                cmp =  k + nums[left] + nums[right] - target;
                t = cmp > 0? cmp:-cmp;
                if (t < dist){
                    dist = t;
                    result = k + nums[left] + nums[right];
                }

                if (cmp == 0)   return target;
                else if (cmp < 0)   left ++;
                else                right --;
                //cmp = cmp < 0? - cmp : cmp;

            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, -3};
        //System.out.println(find(nums, 1));

        int x = 1234567899;
        String num = new StringBuilder().append(x).reverse().toString();
        try{
            System.out.println(Integer.parseInt(num));
        }catch (NumberFormatException e){
            System.out.println(0);
        }

    }
}
