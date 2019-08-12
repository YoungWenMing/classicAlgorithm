public class BinarySearch {

    /**
     * apply binary searching to find the
     * minimum integer in a sorted but rotated
     * array
     * @return
     */
    public static int findMinRotation(int[] rotatedArray) {
        //do not need search when such condition exists
        if (rotatedArray[0] < rotatedArray[rotatedArray.length - 1])
            return rotatedArray[0];
        return findMinRotation(rotatedArray, 0, rotatedArray.length - 1);
    }

    private static int findMinRotation(int[] rotatedArray, int s, int e) {
        int mid = s + (e - s) / 2;

        /**condition when recursion ends*/
        if (e - s == 1)
            return rotatedArray[e];

        int d = rotatedArray[mid] - rotatedArray[s];
        int f = rotatedArray[mid] - rotatedArray[e];
        if (d ==0 && 0 == f){
            int min = rotatedArray[s];
            for (int i = s + 1; i <= e; i ++)
                if (rotatedArray[i] < min)
                    min = rotatedArray[i];
            return min;
        }

        if (d > 0) {
            return findMinRotation(rotatedArray, mid, e);
        }else {
            return findMinRotation(rotatedArray, s, mid);
        }
    }

    /**
     * find a number in a sorted array by
     * binary searching
     * @param n
     * @return
     */
    public static int find(int n, int[] array){
        return find(n , array, 0, array.length - 1);
    }

    private static int find(int n, int[] array, int s, int e){
        if (s > e)
            return -1;

        int mid = s + (e - s) / 2;
        int d = array[mid] - n;
        if (d > 0)
            return find(n, array, s, mid - 1);
        else if (d < 0)
            return find(n, array, mid + 1, e);
        else
            return mid;
    }
}
