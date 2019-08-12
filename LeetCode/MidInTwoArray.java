public class MidInTwoArray {

    public static double findMiddleNum(int[] nums1, int[] nums2){
        int start, end, mid, left, m = nums1.length, n = nums2.length;
        boolean oddOrEven = ((m+n) & 1) ==0;
        int t = 0, goal = oddOrEven? (m + n) / 2: (m + n) / 2+ 1;

        if (nums1.length == 0){
            if ((n & 1) == 0)   return nums2[n / 2];
            else                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }else if (nums2.length == 0){
            if ((m & 1) == 0)   return nums1[m / 2];
            else                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }else {
            start = 0;
            end = m - 1;
            while (start <= end){
                mid = (start + end) / 2;
                left  = findPos(nums2, nums1[mid], start, end);
                if ((t = mid + 1 + left) == goal) break;
                else if (t > goal)      end = mid - 1;
                else                    start = mid + 1;
            }
            if (t == goal){
                if (!oddOrEven);
            }

        }
        return 0;

    }

    private static int findPos(int[] array, int target, int start, int end){
        if (array[start] > target)  return 0;
        int i = start, j = end , mid =start;
        while (i <= j){
            mid = (i + j) / 2;
            if (array[mid] == target && (mid == end || array[mid + 1] != target))
                break;
            else if ( array[mid] <= target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return mid + 1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 4, 5, 9 , 9, 10, 10, 10, 10};
        System.out.println(findPos(array, 0, 0, array.length - 1));
        System.out.println(findPos(array, 11, 0, array.length  - 1));
        System.out.println(findPos(array, 6, 0, array.length - 1));
        System.out.println(findPos(array, 9, 0, array.length - 1));
        System.out.println(findPos(array, 10, 0, array.length - 1));
    }
}
