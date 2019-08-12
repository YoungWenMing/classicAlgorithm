import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class SettleQueens {

    public static int count = 0;

    public static void settle(){
        int[] board = new int[8];
        settle(board, 0);
    }

    private static void settle(int[] board, int k){
        int l;
        boolean v = true;
        if (k == (l = board.length)) {
            System.out.println(Arrays.toString(board));
            count++;
            return;
        }


        for (int i = 0;i < l; i ++){
            board[k] = i;
            v = true;
            for (int j = 0; j < k; j ++){
                v = v & (i != board[j] && k - j != board[k] - board[j] && k - j != board[j] - board[k]);
                if (!v)     break;
            }
            if (v)      settle(board, k + 1);
        }
    }


    public static void main(String[] args){
        //settle();
        //System.out.println(count);
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(-2));
        short i = 1;
        i += 1;

        Stack<Integer> stack = new Stack<>();
        stack.pop();
        /**/
    }
}
