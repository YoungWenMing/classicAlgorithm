import java.util.Queue;
import java.util.Stack;

public class IsOutOrder {

    public static boolean check(int[] inSeq, int[] outSeq) {
        if (inSeq == null && outSeq == null) return true;
        if (inSeq == null || outSeq == null) return false;
        if (inSeq.length != outSeq.length)      return false;

        int l = inSeq.length, i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < l || !stack.empty()){
            while (stack.empty() || stack.peek() != outSeq[j]) {
                if (i == l)     break;
                stack.push(inSeq[i++]);
            }

            if (outSeq[j++] != stack.pop())  return false;
        }
        return true;

    }


    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5},
                a2 = new int[]{5,4,3,2,1},
                a3 = new int[]{4,5,3,2,1},
                a4 = new int[]{3,5,4,2,1},
                a5 = new int[]{3,4,5,2,1},
                a6 = new int[]{4,3,5,1,2},
                a7 = new int[]{3};

        System.out.println(check(array, a2));
        System.out.println(check(array, a3));
        System.out.println(check(array, a4));
        System.out.println(check(array, a5));
        System.out.println(check(array, a6));
        System.out.println(check(array, a7));

    }
}
