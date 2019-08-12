public class SubSeqMaxSum {
    /**
     * find the largest sum among all consecutive sub-sequence
     * of this sequence
     */
    public static int find(int[] seq){
        if (seq.length ==0)     throw new IllegalArgumentException();
        int current = seq[0], maxSum = current;
        for (int i : seq){
            if (current + i < 0)
                current = i;
            else
                current += i;
            if (maxSum < current)   maxSum = current;
        }
        return maxSum;
    }


    public static void main(String[] args){
        int a[] = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("Max sum of sub-seq in this array: " + find(a));
        a = new int[]{-3, -2, -9};
        System.out.println("Max sum of sub-seq in this array: " + find(a));
    }
}
