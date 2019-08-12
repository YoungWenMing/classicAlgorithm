public class CountNumber {

    public static int binarySearch(int[] array, int x){
        if (array == null)  return -1;
        int start = 0, end = array.length - 1, mid;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (array[mid] == x)
                return mid;
            else if (array[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int getFirstK(int[] array, int x, int start, int end){
        if (start > end)    return -1;
        int mid = start + (end - start) / 2;
        if (array[mid] > x)     return getFirstK(array, x, start, mid - 1);
        else if (array[mid] < x)    return getFirstK(array, x, mid + 1, end);
        else {
            if (mid == 0 || array[mid - 1] != x)
                return mid;
            return getFirstK(array,x, start, mid - 1);
        }

    }

    private static int getLastK(int[] array, int x, int start, int end){
        if (start > end)    return -1;
        int mid = start + (end - start) / 2;
        if (array[mid] > x)     return getLastK(array, x, start, mid - 1);
        else if (array[mid] < x)    return getLastK(array, x, mid + 1, end);
        else {
            if (mid == array.length -1 || array[mid + 1] != x)
                return mid;
            return getLastK(array,x, mid + 1, end);
        }
    }

    public static int count(int[] array, int x){
        int pos = binarySearch(array, x);
        if (pos == -1)  return 0;
        int total = 1, i = pos - 1, j = pos + 1;
        while (i >= 0){
            if (array[i--] == x)  total ++;
            else                break;
        }
        while (j < array.length){
            if (array[j++] == x)  total ++;
            else                break;
        }
        return total;
    }

    public static int countV2(int[] array, int x){
        if (array == null)   return 0;
        int p1 = getFirstK(array, x, 0, array.length - 1),
                p2 = getLastK(array, x, 0 , array.length - 1);
        if (p1 == -1)           return 0;
        else                    return p2 - p1 + 1;
    }

    public static int findMissingNum(int[] array){
        int start = 0, end = array.length - 1, mid;

        while (end >= start){
            mid = (end + start) >> 1;
            if (array[mid] != mid){
                if (mid == 0|| array[mid-1] == mid-1)
                    return mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return array.length;
    }

    public static int findCorrectIndex(int[] array){
        if (array == null)      return -1;
        int start = 0, end = array.length -1, mid;
        while (end >= start){
            mid = (start + end) >> 1;
            int numMid = array[mid];
            if (numMid == mid)  return numMid;
            else if (numMid > mid)      end = mid - 1;
            else                        start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int array[] = new int[]{1, 3, 4, 8, 8, 8, 10, 14, 22};
        System.out.println(binarySearch(array, 8));
        System.out.println(binarySearch(array, 9));
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 22));

        System.out.println(count(array, 8));
        System.out.println(getFirstK(array, 8, 0, array.length - 1));
        System.out.println(getLastK(array, 8, 0, array.length - 1));
        System.out.println(getLastK(array, 10, 0, array.length - 1));
        System.out.println(getLastK(array, 100, 0, array.length - 1));

        System.out.println(countV2(array, 8));

        array = new int[]{1};
        System.out.println(countV2(array, 2));
        array = new int[]{1, 2, 3, 4, 5};
        System.out.println(findMissingNum(array));
        System.out.println("**********************");
        array = new int[]{0};
        System.out.println(findCorrectIndex(array));
        array = new int[]{-4, -2, 0, 3, 5, 9};
        System.out.println(findCorrectIndex(array));
        array = new int[]{-4, -2, 0, 1, 2, 5};
        System.out.println(findCorrectIndex(array));
        array = new int[]{-4, -2, 0, 2, 5, 9};
        System.out.println(findCorrectIndex(array));
    }
}
