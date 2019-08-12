import java.util.Arrays;

public class AssembleMin {


    public static void assemble(int[] ints){
        if (ints.length == 0)
            System.out.println("no integer can be generated!");
        else {
            sort(ints, 0, ints.length - 1);
            for (int i : ints)
                System.out.print(i);
            System.out.println("\n");
        }

    }


    /**
     * this is a protocol to determine which integer is more suitable
     * to be put to front position when concatenating  these two integers
     * together as one new but smaller integer
     * rule:
     *      1 smaller digits has higher priority
     *      2 apply rule 1 when two digits are same to next digits
     *      3 rule 1 and 2 do not get final result and one integer is shorter
     *          compare the very first digit of shorter one to another's focusing
     *          digit
     *      4 return the first when the 3 rules above fail
     * @param i
     * @param j
     * @return
     */
    private static boolean comparePriority(int i, int j){
        String is = Integer.toString(i), js = Integer.toString(j);
        int p = 0;
        while (p < is.length() || p < js.length()){
            //if (p == is.length() && p == js.length())   return true;
            if (p == is.length())               return is.charAt(0) < js.charAt(p);
            if (p == js.length())               return is.charAt(p) < js.charAt(0);
            if (is.charAt(p) != js.charAt(p))    return is.charAt(p) < js.charAt(p);
            p ++;
        }
        return true;
    }

    private static void sort(int[] ints, int start, int end){
        if (end <= start)   return;
        int pivot = ints[start], i = start + 1, j = end;
        while (true){
            while (comparePriority(ints[i], pivot))     if (++i > end) break;
            while (!comparePriority(ints[j], pivot))    if (--j < start) break;
            if (j > i){
                int temp = ints[i]; ints[i] = ints[j]; ints[j] = temp;
            }
            break;
        }
        int temp = ints[j]; ints[j] = pivot; ints[start] = temp;
        sort(ints, start, j - 1);
        sort(ints, j + 1, end);
    }


    public static void main(String[] args){
        int a = 621, b = 620;
        System.out.printf("%d should stand in front of %d: %b", a, b, comparePriority(a, b));

        int[] array = new int[]{5, 1, 2, 4,3, 9, 7};
        sort(array, 0 ,array.length - 1);
        System.out.println(Arrays.toString(array));

        assemble(array);
        array = new int[]{3, 32, 321};
        assemble(array);

        array = new int[]{92, 92, 1, 10};
        assemble(array);
    }
}
