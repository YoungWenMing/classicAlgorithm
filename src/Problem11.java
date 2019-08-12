public class Problem11 {

    public static int findMin(int[] rotatedArray){
        if (rotatedArray == null || rotatedArray.length == 0)
            throw new IllegalArgumentException();
        int head = 0, tail = rotatedArray.length - 1, mid = head;

        while (rotatedArray[head] >= rotatedArray[tail]){
            if (tail - head == 1){
                mid = tail;
                break;
            }
            mid  = (head + tail) / 2;
            if (rotatedArray[mid] == rotatedArray[head]
                && rotatedArray[mid] == rotatedArray[tail]){
                mid = searchInOrder(rotatedArray, head, tail);
                break;
            }
            if (rotatedArray[mid] >= rotatedArray[head])
                head = mid;
            else
                tail = mid;
        }
        return rotatedArray[mid];
    }


    private static int searchInOrder(int[] array, int start, int end){
        int result = array[start];
        for (int i = start; i <= end; i ++){
            if (result > array[i])      start = i;
        }
        return start;
    }

    public static void main(String[] args){
        int[] array = new int[]{3, 4, 5, 0, 2};
        System.out.println(findMin(array));
    }

}
