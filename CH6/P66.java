import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P66 {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int  N = scanner.nextInt(), A[] = new int[N],
                B1[] = new int[N], B2[] = new int[N], B[] = new int[N];
        for (int i = 0; i < N; i ++){
            A[i] = scanner.nextInt();
        }

        B1[N - 1] = 1;
        for (int i = N - 2; i >= 0; i --)
            B1[i] = B1[i + 1] * A [i + 1];

        B2[0] = 1;
        for (int i = 1; i <= N - 1;i ++)
            B2[i] = B2[i - 1] * A[i - 1];

        for (int i = 0; i < N; i ++)
            B[i] = B1[i] * B2[i];

        System.out.println(Arrays.toString(B));

        HashSet<Character> sets = new HashSet<>();
        sets.contains('c');*/

        System.out.println( Solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println( Solution.lengthOfLongestSubstring("pwwaohfahgaguyiusa"));
        System.out.println( Solution.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz"));
        System.out.println( Solution.lengthOfLongestSubstring("dvdf"));

    }

}

class Solution {
    static public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> pos = new HashMap<>();
        int l = s.length(), m = 0, t = 0, start = 0, p;
        char c;
        for (int i = 0; i < l; i ++){
            c = s.charAt(i);
            if(pos.containsKey(c) &&(p = pos.get(c)) >= start){
                start = p + 1;
                t = i - p - 1;
            }
            m = ++t > m? t:m;
            pos.put(c, i);
        }
        return m;
    }
}