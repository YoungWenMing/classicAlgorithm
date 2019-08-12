import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class CheckInclusion {

    public static boolean permutate(String s1, String s2){
        int nums[] =  new int[26], start = -1, total = s1.length();
        int p, l = s2.length();
        Queue<Integer>[] posQ = new Queue[26];
        HashMap<Character, Integer> set = new HashMap<>();

        for (char c : s1.toCharArray()){
            p = c - 'a';
            nums[p] ++;
            set.put(c, nums[p]);
            if(posQ[p] == null) posQ[p] = new LinkedList<>();
        }

        char c;
        for (int i = 0; i < l; i ++){
            c = s2.charAt(i);
            p = c - 'a';
            if (set.containsKey(c) && start== -1){
                start = i;
                nums[p] --;
                posQ[p].add(i);
                total --;
            }else if (set.containsKey(c)){
                if (nums[p] == 0){
                    int startNew = posQ[p].peek(), t;
                    for (int j = start; j <= startNew; j ++){
                        t = s2.charAt(j) - 'a';
                        nums[t] ++;
                        posQ[t].poll();
                        total ++;
                    }
                    start = startNew + 1;
                }
                nums[p] --;
                posQ[p].add(i);
                total --;

            }else if (start != -1){
                for (char x: set.keySet()){
                    nums[x - 'a'] = set.get(x);
                    posQ[x - 'a'].clear();
                }
                total = s1.length();
                start = -1;
            }
            if (total == 0) return true;
        }

        return false;
    }

    public static boolean checkIn(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length(),
                num1[] = new int[26], num2[] = new int[26];
        for (char c : s1.toCharArray())
            num1[c - 'a'] ++;

        int p;
        for (int i = 0; i < l1; i ++){
            p = s2.charAt(i) - 'a';
            num2[p] ++;
        }

        for (int i = l1; i < l2; i ++){
            if (Arrays.equals(num1, num2))  return true;
            p = s2.charAt(i - l1) - 'a';
            num2[p] --;
            p = s2.charAt(i) - 'a';
            num2[p] ++;
        }

        return Arrays.equals(num1, num2);
    }

    public static void main(String[] args) {
        String s1 = "aabc", s2 = "healobcwoacbarld";
        System.out.println(permutate(s1, s2));

        s1 = "abc";
        s2 = "bbbca";
        System.out.println(checkIn(s1,s2));
    }

}
